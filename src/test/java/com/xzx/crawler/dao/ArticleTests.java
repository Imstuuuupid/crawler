package com.xzx.crawler.dao;

import com.xzx.crawler.entity.Article;
import com.xzx.crawler.entity.Process;
import com.xzx.crawler.pipline.ArticlePipline;
import com.xzx.crawler.processor.ArticleProcessor;
import com.xzx.crawler.service.ProcessHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xzx
 * @date 2021/01/02 21/32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ArticleTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticlePipline articlePipline;

    @Autowired
    private ArticleProcessor processor;

    @Autowired
    private ProcessHandler processHandler;


    @Test
    public void insert() {
        Article b = new Article();
        b.setTitle("bb");
        b.setAuthor("xzx");
        b.setUrl("123");
        b.setAuthority(21d);
        b.setHub(45d);
        b.setTaskId(1254234l);
        b.setDesc("135");


        Article a = new Article();
        a.setTitle("aa");
        a.setAuthor("xxxx");
        a.setUrl("qweqwr");
        a.setAuthority(44d);
        a.setHub(454d);
        a.setTaskId(444412545214234l);
        a.setDesc("222");

        List<Article> list = new ArrayList<>();
        list.add(b);
        list.add(a);

        articleMapper.insertList(list);
    }

    @Test
    public void start() {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(processor)
//                初始种子页面
                .addUrl("https://www.csdn.net/nav/db")
//                保存路径
                .addPipeline(articlePipline)
//                开启线程
                .thread(10)
                .run();
        endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);
        System.out.println("爬取结束，抓取了" + processor.getCount() + "条记录");
//        获得爬取结果
        List<Process> res = articlePipline.getRes();
//        对结果进行节点化
        List<Process> edges = processHandler.findEdges(res);
//        使用HITS算法
        List<Process> processes = processHandler.runHits(edges);
//        写入库中
        processHandler.insertList(processes);
    }
}
