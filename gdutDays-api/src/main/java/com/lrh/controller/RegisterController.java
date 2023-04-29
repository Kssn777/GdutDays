package com.lrh.controller;

import com.lrh.entity.param.RegisterParam;
import com.lrh.entity.Result;
import com.lrh.service.RegisterService;
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
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping()
    public Result register(@RequestBody RegisterParam registerParam){
        return registerService.register(registerParam);
    }
}
