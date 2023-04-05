package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.entity.Test;
import com.lrh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrh
 * @description
 * @date 2023/2/10
 */
@RestController

public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test",method = {RequestMethod.GET,RequestMethod.POST})
    public Result test(){
        return testService.test();
    }


}
