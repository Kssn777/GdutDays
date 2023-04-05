package com.lrh.service;

import com.lrh.entity.param.LoginParam;
import com.lrh.entity.Result;
import com.lrh.entity.User;

public interface LoginService {

    Result login(LoginParam loginParam);

    User checkToken(String token);

    Result logout(String token);
}
