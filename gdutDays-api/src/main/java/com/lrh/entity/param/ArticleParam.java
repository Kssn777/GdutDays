package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/4/24
 */
@Data
public class ArticleParam {
    private String title;
    private String content;
    private Long categoryId;
}
