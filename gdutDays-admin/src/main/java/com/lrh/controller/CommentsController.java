package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.entity.param.CommentParam;
import com.lrh.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrh
 * @description
 * @date 2023/3/18
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/{articleId}/{page}")
    public Result showComments(@PathVariable Long articleId,@PathVariable int page){
        return commentsService.showComments(articleId,page);
    }

    @PostMapping("/add")
    public Result addComments(@RequestBody CommentParam commentParam){
        return commentsService.addComments(commentParam);
    }
}
