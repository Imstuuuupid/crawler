package com.xzx.crawler.processor;

import com.xzx.crawler.pipline.ArticlePipline;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 *
 * @author xzx
 * @date 2020/12/22 17/02
 */
public class DemoProcessor implements PageProcessor {

    /**
     * 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count = 0;

    /**
     * 初始页面抓取元素的xpath路径
     */
    private static final String INIT_ELEMENT = "ul[@class=\"feedlist_mod db\"]";

    /**
     * 后续链接的xpath路径
     */
    private static final String CATCH_ELEMENT = "div[@class=\"title-box\"]/a";

    /**
     * 抓取页面链接的正则表达式
     */
    private static final String URL_REGULAR = "https://blog.csdn.net/[a-z A-Z 0-9 -]+/article/details/[a-z A-Z 0-9 -]+";


    @Override
    public void process(Page page) {

//        获取当前页面url
        page.putField("articleURL", page.getUrl().toString());
//        获取当前文章标题
        page.putField("articleTitle", page.getHtml().xpath("h1[@id=\"articleContentId\"]/text()").get());
//        获取当前文章作者
        page.putField("author", page.getHtml().xpath("a[@class=\"follow-nickName\"]/text()"));

        if (page.getResultItems().get("articleTitle") == null) {
            //skip this page
            page.setSkip(true);
        } else {
            System.out.println("抓取的内容：" + page.getResultItems().get("articleTitle"));
            count++;
        }

//        获取页面子链接
        List<String> all = page.getHtml().xpath(CATCH_ELEMENT).links().regex(URL_REGULAR).all();

//        初始页面抓取策略
        if (count == 0) {
            System.out.println("init！！！");
            page.addTargetRequests(
                    page.getHtml().xpath(INIT_ELEMENT).links().regex(URL_REGULAR).all()
            );
        }
        if (count < 20) {
            page.addTargetRequests(all);
        }
    }

    public int getCount() {
        return count;
    }

//    public static void main(String[] args) {
//        long startTime, endTime;
//        System.out.println("开始爬取...");
//        startTime = System.currentTimeMillis();
//        Spider.create(new DemoProcessor())
////                初始种子页面
//                .addUrl("https://www.csdn.net/nav/db")
////                保存路径
//                .addPipeline(new ArticlePipline())
////                开启线程
//                .thread(5)
//                .run();
//        endTime = System.currentTimeMillis();
//        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + count + "条记录");
//    }

    @Override
    public Site getSite() {
        return site;
    }
}
