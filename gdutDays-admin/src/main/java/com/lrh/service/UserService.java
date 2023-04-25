package com.lrh.service;

import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.entity.param.PasswordParam;

public interface UserService {
    User findUser(String account, String password);
    User getUserByAccount(String account);

    Result findUserByToken(String token);

    Result getUserInfoById(Long id);

    Result changeAvatar(String avatar);

    Result updateUserName(Long id, String newName);

    Result updatePassword(Long id, PasswordParam passwordParam);
}
