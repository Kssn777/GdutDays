package com.lrh.entity;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/17
 */
@Data
public class Article {
    private Long id;
    private String title;
    private Long createDate;
    private String content;
    private Double score;
    private Integer commentCounts;
    private Integer likenums;
    private Long authorId;
    private Long categoryId;

}
