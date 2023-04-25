package com.lrh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/17
 */
@Data
public class Article {
    @TableId(type = IdType.AUTO)
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
