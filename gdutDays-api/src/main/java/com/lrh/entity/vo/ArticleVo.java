package com.lrh.entity.vo;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/19
 */
@Data
public class ArticleVo {
    private Long id;
    private String title;
    private String createDate;
    private String content;


    private Integer commentCounts;
    private Integer likenums;
    private String authorName;
    private String avatar;
    private Long authorId;

    private int isLiked;//1为点赞,-1为点踩,0无操作

    private int isFollowed;//1为已关注 0为未关注

}
