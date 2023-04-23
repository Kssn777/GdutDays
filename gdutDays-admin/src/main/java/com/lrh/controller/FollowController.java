package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.entity.param.FollowParam;
import com.lrh.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrh
 * @description
 * @date 2023/3/26
 */
@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("follow/current/{page}")
    public Result getCurrentFollowList(@PathVariable("page")int page){
        return followService.getCurrentFollowList(page);
    }

    @GetMapping("follow/{id}/{page}")
    public Result getFollowListById(@PathVariable("id") Long id,@PathVariable("page")int page){
        return followService.getFollowListById(id,page);
    }

    @GetMapping("fans/current/{page}")
    public Result getCurrentFansList(@PathVariable("page")int page){
        return followService.getCurrentFansList(page);
    }

    @GetMapping("fans/{id}/{page}")
    public Result getFansListById(@PathVariable("id") Long id,@PathVariable("page")int page){
        return followService.getFansListById(id,page);
    }

    @PutMapping("follow")
    public Result followOperation(@RequestBody FollowParam followParam){
        return followService.followOperation(followParam);
    }




}
