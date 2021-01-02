package com.xzx.crawler.pipline;

import com.xzx.crawler.dao.ArticleMapper;
import com.xzx.crawler.entity.Article;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * 保存数据到库
 * @author xzx
 * @date 2021/01/02 18/12
 */
@Repository
public class ArticlePipline implements Pipeline {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Article article = new Article();
        Map<String, Object> resultMap = resultItems.getAll();
        if(MapUtils.isNotEmpty(resultMap)) {
            String url = String.valueOf(resultMap.get("articleURL"));
            String title = String.valueOf(resultMap.get("articleTitle"));
            String author = String.valueOf(resultMap.get("author"));
            article.setAuthor(author);
            article.setTitle(title);
            article.setUrl(url);
            System.out.println(articleMapper);
            articleMapper.insert(article);
        }

    }
}
