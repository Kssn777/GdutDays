package com.lrh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/3/26
 */
@Data
public class UserFollow {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long followId;
}
