package com.lrh.entity.vo;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/3/19
 */
@Data
public class CommentsVo {
    private Long id;
    private String nickname;
    private String toNickname;
    private String content;
    private String createDate;
    private String avatar;

    private Long userId;
}
