package com.lrh.service;

import com.lrh.entity.Result;
import com.lrh.entity.User;

public interface UserService {
    User findUser(String account, String password);
    User getUserByAccount(String account);

    Result findUserByToken(String token);

    Result getUserInfoById(Long id);
}
