package com.xzx.crawler.processor;

import com.xzx.crawler.entity.Process;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author xzx
 * @date 2020/12/22 17/02
 */
@Slf4j
@Component
public class ArticleProcessor implements PageProcessor {

    /**
     * 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    private static int count = 0;

    public int getCount() {
        return count;
    }

    private static final String WEBS = "webs";

    /**
     * 抓取页面的限制边界
     */
    @Value("${processor.limit}")
    private int LIMIT;

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

    /**
     * 关键词列表
     */
    private static final List<String> KEY = Lists.newArrayList("mysql", "Mysql", "MYSQL", "数据库");

    /**
     * 时间戳标识批次
     */
    private static final Long TASK_ID = System.currentTimeMillis();

    @Value("${processor.number}")
    private String number;

    @Value("${processor.process}")
    private String process;

    public Long getTaskId() {
        return TASK_ID;
    }


    @Override
    public Site getSite() {
        return site;
    }


    @Override
    public void process(Page page) {

//        抓取需求元素
        analyseElement(page);

//        URL管理
        fetchStrategy(page);

    }

    /**
     * 获取元素
     * @author xzx
     * @date 2021/01/03 22:37
     * @param page
     * @return void
     */
    private void analyseElement(Page page) {

//        记录当前编号
        Integer number = count;
        String url = page.getUrl().toString();
        String title = page.getHtml().xpath("h1[@id=\"articleContentId\"]/text()").get();
        String author = page.getHtml().xpath("a[@class=\"follow-nickName\"]/text()").get();
        String desc = page.getHtml().xpath("meta[@name=\"description\"]/@content").get();

//        获取子网页链接
        List<String> webs = null;
        if (count == 0) {
            webs = page.getHtml().xpath(INIT_ELEMENT).links().regex(URL_REGULAR).all();
        } else {
            webs = page.getHtml().xpath(CATCH_ELEMENT).links().regex(URL_REGULAR).all();
        }
        if (CollectionUtils.isNotEmpty(webs)) {
            webs = webs.stream().distinct().collect(Collectors.toList());
        }
        page.putField(WEBS, webs);
        Process tempProcess = new Process(title, author, desc, url, count, webs, TASK_ID);
        page.putField(process, tempProcess);


        if (url == null || !contains(title)) {
            //skip this page
            page.setSkip(true);
        } else {
            count++;
        }
    }

    private Boolean contains(String title) {
        if (title == null) {
            return false;
        }
        boolean flag = false;
        for (String key : KEY) {
            if (title.contains(key)) {
                return true;
            }
        }
        return flag;
    }

    /**
     * 页面的抓取策略
     * @author xzx
     * @date 2021/01/03 22:36
     * @param page
     * @return void
     */
    private void fetchStrategy(Page page) {

//        获取页面子链接
        List<String> all = page.getResultItems().get(WEBS);
//        终止策略
        if (count < LIMIT) {
            page.addTargetRequests(all);
        }
    }

}
