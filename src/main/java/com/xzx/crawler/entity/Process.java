package com.xzx.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 过程类，用来存储爬取的数据以及相关信息
 * @author xzx
 * @date 2021/01/04 01/58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private String title;

    private String author;

    private String desc;

    private String url;

    /**
     * 编号
     */
    private Integer count;

    /**
     * 从这个网页中获得的链接
     */
    private List<String> webs;

    /**
     * 用于Hits算法计算的边
     */
    private List<Integer> edges;

    private Long taskId;

    public void show() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("title = ").append(title).append("\r\n");
        sb.append(",count = ").append(count).append("\r\n");
        sb.append(",edges = ").append(edges).append("\r\n");
        sb.append("]");
        System.out.println(sb);
    }
}
