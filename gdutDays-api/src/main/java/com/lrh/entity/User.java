package com.lrh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String account;
    private String password;
    private String username;
    private String email;
    private String avatar;
}
