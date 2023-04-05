package com.lrh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.entity.Article;
import com.lrh.entity.vo.ArticleVo;

public interface ArticleDao extends BaseMapper<Article> {
    IPage<ArticleVo> listArticle(Page<ArticleVo> page, Long categoryId,Long userId);

    IPage<ArticleVo> searchArticles(Page<ArticleVo> page,String keyword);

    ArticleVo viewById(Long id, Long userId);
}
