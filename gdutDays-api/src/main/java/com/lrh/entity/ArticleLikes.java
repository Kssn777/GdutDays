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
public class ArticleLikes {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long articleId;
    private Integer likeStatus;//0为无操作  -1点踩  1点赞

}
