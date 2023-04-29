package com.lrh.controller;

import com.lrh.entity.param.LoginParam;
import com.lrh.entity.Result;
import com.lrh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lrh
 * @description
 * @date 2023/2/15
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
