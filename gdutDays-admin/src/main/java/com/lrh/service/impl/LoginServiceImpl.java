package com.lrh.service.impl;

import com.alibaba.fastjson.JSON;
import com.lrh.dao.UserDao;
import com.lrh.entity.param.LoginParam;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.service.LoginService;
import com.lrh.service.UserService;
import com.lrh.utils.Base64Util;
import com.lrh.utils.ErrorMsg;
import com.lrh.utils.JWTUtils;
import com.lrh.utils.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result login(LoginParam loginParam) {
        String account = loginParam.getAccount();

        String password = loginParam.getPassword();
        //判空
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorMsg.ACCOUNT_PASSWORD_ERROR.getCode(),
                    null,
                    ErrorMsg.ACCOUNT_PASSWORD_ERROR.getMessage());
        }
        //查表
        password = Base64Util.decode(password);
        User user = userService.findUser(account,password);
        if(user == null){
            return Result.fail(ErrorMsg.ACCOUNT_PASSWORD_ERROR.getCode(),
                    null,
                    ErrorMsg.ACCOUNT_PASSWORD_ERROR.getMessage());
        }
        String token = JWTUtils.createToken(user.getId());


        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(user),1, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public User checkToken(String token) {
        if(StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if(stringObjectMap==null){
            return null;
        }
        String userJson = (String) redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)){
            return null;
        }
        User user = JSON.parseObject(userJson, User.class);
        return user;
    }

    @Override
    public Result logout(String token) {

        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);
    }


}
