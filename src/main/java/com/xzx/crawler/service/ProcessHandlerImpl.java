package com.xzx.crawler.service;

import com.xzx.crawler.algorithm.Hits;
import com.xzx.crawler.dao.ArticleMapper;
import com.xzx.crawler.dao.ArticleTestMapper;
import com.xzx.crawler.entity.Article;
import com.xzx.crawler.entity.Process;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Process处理器的实现类
 * @author xzx
 * @date 2021/01/04 02/27
 */
@Slf4j
@Service
public class ProcessHandlerImpl implements ProcessHandler {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleTestMapper articleTestMapper;

    @Override
    public List<Process> findEdges(List<Process> processList) {
        List<Process> list = processList;
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "处理后的process列表为空");

//        获取url对应位置
        Map<String, Integer> urlNumberMap = list.stream()
                .collect(Collectors.toMap(Process::getUrl, Process::getCount, (a, b) -> b));

//        找到每一个网页子网页的位置，然后将他们与父网页连接形成边
        for (Process temp : list) {
            List<String> webs = temp.getWebs();
            List<Integer> nodes = new ArrayList<>();
            for (String web : webs) {
                if (urlNumberMap.containsKey(web)) {
                    nodes.add(urlNumberMap.get(web));
                } else {
                    continue;
                }
            }
            temp.setEdges(nodes);
        }

        return list;
    }

    @Override
    public List<Process> runHits(List<Process> processList) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(processList), "计算完边后的process列表为空");

        List<Article> insert = transform(processList);
        articleTestMapper.deleteAll();
        articleTestMapper.insertList(insert);

        Set<Integer> vertex = processList.stream().map(Process::getCount).collect(Collectors.toSet());
        Hits hits = new Hits(vertex.size());
        hits.addVertex(vertex.toArray());
        for (Process temp : processList) {
            List<Integer> edges = temp.getEdges();
            for (Integer edge : edges) {
                try {
                    hits.addEdge(temp.getCount(),edge);
                }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    log.error("{},{}",temp,arrayIndexOutOfBoundsException);
                }
            }
        }
        processList = hits.printResultPage(processList);
        return processList;
    }

    @Override
    public void insertList(List<Process> processList) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(processList), "需要插入的列表为空");
//        由小到大排序
        processList.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1 != null && o2 != null) {
                    if (o1.getAuthority()+o1.getHub() < o2.getAuthority()+o2.getHub()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 0;
            }
        });

        List<Article> insert = transform(processList);
        articleMapper.insertList(insert);

    }

    private List<Article> transform(List<Process> processList) {
        List<Article> insert = new ArrayList<>();
        for (Process temp : processList) {
            Article article = new Article();
            article.setTitle(temp.getTitle());
            article.setAuthor(temp.getAuthor());
            article.setDesc(temp.getDesc());
            article.setUrl(temp.getUrl());
            article.setAuthority(temp.getAuthority());
            article.setHub(temp.getHub());
            article.setTaskId(temp.getTaskId());
            insert.add(article);
        }
        return insert;
    }
}
