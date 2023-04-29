package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/3/21
 */
@Data
public class CommentParam {
    private Long toUserId;
    private Long articleId;
    private String content;

}
