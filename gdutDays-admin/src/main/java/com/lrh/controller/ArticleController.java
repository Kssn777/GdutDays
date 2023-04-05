package com.lrh.controller;

import com.lrh.entity.Result;
import com.lrh.entity.param.ArticleLikesParam;
import com.lrh.entity.param.PageParam;
import com.lrh.entity.param.SearchParam;
import com.lrh.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrh
 * @description
 * @date 2023/2/19
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 分页获取文章列表
     * @param pageParam
     * @return
     */
    @PostMapping
    public Result listArticles(@RequestBody PageParam pageParam,@RequestHeader(value = "Authorization",required = false)String token){
        return articleService.listArticles(pageParam,token);

    }


    /**
     * 根据关键字查询文章
     */
    @GetMapping("/search")
    public Result searchArticles(@RequestParam("keyword") String keyword){

        return articleService.searchArticles(keyword);
    }

    /**
     * 点赞
     * @param param
     * @return
     */
    @PutMapping("/like")
    public Result updateArticleLikes(@RequestBody ArticleLikesParam param){
        return articleService.updateArticleLikes(param);
    }

    /**
     * 根据id打开文章详情页
     */

    @GetMapping("view/{id}")
    public Result view(@PathVariable("id")Long id,@RequestHeader(value = "Authorization",required = false)String token){
        return articleService.view(id,token);
    }
}
