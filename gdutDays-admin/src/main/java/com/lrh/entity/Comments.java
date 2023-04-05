package com.lrh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/3/18
 */
@Data
public class Comments {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long articleId;
    private Long userId;
    private Long touserId;
    private String comments;
    private String createDate;

}
