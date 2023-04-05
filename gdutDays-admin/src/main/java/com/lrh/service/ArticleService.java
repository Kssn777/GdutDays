package com.lrh.service;

import com.lrh.entity.Result;
import com.lrh.entity.param.ArticleLikesParam;
import com.lrh.entity.param.PageParam;
import com.lrh.entity.param.SearchParam;

public interface ArticleService {

    Result listArticles(PageParam pageParam,String token);

    Result searchArticles(String keyword);

    Result updateArticleLikes(ArticleLikesParam param);

    Result view(Long id,String token);
}
