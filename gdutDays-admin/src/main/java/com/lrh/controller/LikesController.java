package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lrh
 * @description
 * @date 2023/2/24
 */
@RequestMapping("/likes")
@RestController
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/getLikes")
    public Result getLikes(){
        return likesService.getLikes();
    }
}
