package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@Data
public class RegisterParam {
    private String account;
    private String username;
    private String email;
    private String password;
}
