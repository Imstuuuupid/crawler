package com.xzx.crawler.dao;

import com.xzx.crawler.entity.Article;
import com.xzx.crawler.pipline.ArticlePipline;
import com.xzx.crawler.processor.DemoProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

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

    @Test
    public void insert()
    {
        Article article = new Article();
        article.setUrl("www");
        article.setAuthor("xzx");
        article.setDesc("test");
        article.setTitle("22");
        int insert = articleMapper.insert(article);
        log.info("{}",insert);
    }

    @Test
    public void test(){
        DemoProcessor processor = new DemoProcessor();
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(processor)
//                初始种子页面
                .addUrl("https://www.csdn.net/nav/db")
//                保存路径
                .addPipeline(articlePipline)
//                开启线程
                .thread(5)
                .run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + processor.getCount() + "条记录");
    }
}
