package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/4/25
 */
@Data
public class PasswordParam {
    private String oldPassword;
    private String newPassword;
}
