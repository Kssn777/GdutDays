package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/21
 */
@Data
public class ArticleLikesParam {
    private Long articleId;
    private Integer operation;
    private Integer like_num;
}
