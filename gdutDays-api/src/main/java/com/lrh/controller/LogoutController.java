package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lrh
 * @description
 * @date 2023/2/23
 */
@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization")String token){
        return loginService.logout(token);
    }
}
