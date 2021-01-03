package com.xzx.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * data
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    private Long id;

    private String title;

    private String author;

    private String desc;

    private String url;

    private Long taskId;

}