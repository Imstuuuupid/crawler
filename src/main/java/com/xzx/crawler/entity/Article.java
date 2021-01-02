package com.xzx.crawler.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * data
 * @author 
 */
@Data
public class Article implements Serializable {
    private Long id;

    private String title;

    private String author;

    private String desc;

    private String url;

    private static final long serialVersionUID = 1L;
}