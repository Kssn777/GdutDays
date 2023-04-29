package com.lrh.service.impl;

import com.lrh.dao.UserDao;
import com.lrh.entity.param.RegisterParam;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.service.RegisterService;
import com.lrh.service.UserService;
import com.lrh.utils.ErrorMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@Service
public class RegisterImpl implements RegisterService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Override
    public Result register(RegisterParam registerParam) {
        String account = registerParam.getAccount();
        String username = registerParam.getUsername();
        String email = registerParam.getEmail();
        String password = registerParam.getPassword();
        //判空
        if(StringUtils.isBlank(account) || StringUtils.isBlank(username) || StringUtils.isBlank(email) || StringUtils.isBlank(password)){
            return Result.fail(ErrorMsg.REGISTER_PARAM_ERROR.getCode(), null,ErrorMsg.REGISTER_PARAM_ERROR.getMessage());
        }
        //判断该账号有无被注册
        User user = userService.getUserByAccount(account);
        //user不为null代表已被注册
        if(user != null){
            return Result.fail(ErrorMsg.REGISTER_FAIL.getCode(),null,ErrorMsg.REGISTER_FAIL.getMessage());
        }
        //数据库添加新用户
        User newUser = new User();
        newUser.setAccount(account);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUsername(username);
        int insert = userDao.insert(newUser);
        if(insert != 1){
            return Result.fail(ErrorMsg.SYSTEM_ERROR.getCode(),null,ErrorMsg.SYSTEM_ERROR.getMessage());
        }
        return Result.success(null);
    }
}
