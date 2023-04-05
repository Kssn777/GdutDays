package com.lrh.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.dao.ArticleDao;
import com.lrh.dao.ArticleLikesDao;
import com.lrh.entity.Article;
import com.lrh.entity.ArticleLikes;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.entity.param.ArticleLikesParam;
import com.lrh.entity.param.PageParam;
import com.lrh.entity.param.SearchParam;
import com.lrh.entity.vo.ArticleVo;
import com.lrh.service.ArticleService;
import com.lrh.service.FollowService;
import com.lrh.service.LoginService;
import com.lrh.utils.ErrorMsg;
import com.lrh.utils.JWTUtils;
import com.lrh.utils.UserThreadLocal;
import com.sun.jmx.snmp.tasks.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author lrh
 * @description
 * @date 2023/2/19
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleLikesDao articleLikesDao;

    @Autowired
    private LoginService loginService;

    @Autowired
    private FollowService followService;

    @Override
    public Result listArticles(PageParam pageParam,String token) {
        if(pageParam == null){
            pageParam = new PageParam();
        }
        String jsonString = (String) redisTemplate.opsForValue().get("TOKEN_" + token);
        User user = JSON.parseObject(jsonString, User.class);
        Long userId  = user==null?null:user.getId();

        Page<ArticleVo> page = new Page<ArticleVo>(pageParam.getPage(),pageParam.getPageSize());
        IPage<ArticleVo> articleIPage = articleDao.listArticle(page, pageParam.getCategoryId(),userId);

        return Result.success(articleIPage);
    }

    @Override
    public Result searchArticles(String keyword) {
        Page<ArticleVo> page = new Page(1,10);
        IPage<ArticleVo> articleVoIPage = articleDao.searchArticles(page,keyword);
        return Result.success(articleVoIPage);
    }

    @Override
    public Result updateArticleLikes(ArticleLikesParam param) {
        Long articleId = param.getArticleId();
        Integer op = param.getOperation();
        Integer like_num = param.getLike_num();

        User user = UserThreadLocal.get();
        Long userId = user.getId();
        ArticleLikes articleLikes = new ArticleLikes();
        articleLikes.setLikeStatus(op);
        //更改点赞状态
        LambdaUpdateWrapper<ArticleLikes> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ArticleLikes::getArticleId,articleId)
                .eq(ArticleLikes::getUserId, userId);
        articleLikesDao.update(articleLikes,wrapper);

        //修改点赞数  点赞才修改
        if(like_num != null){
            LambdaUpdateWrapper<Article> updateWrapper= new LambdaUpdateWrapper<>();
            updateWrapper.eq(Article::getId,articleId)
                    .setSql("`likenums` = " + like_num);
            articleDao.update(null,updateWrapper);
        }

        return Result.success(null);
    }

    @Override
    public Result view(Long id,String token) {

        String jsonString = (String) redisTemplate.opsForValue().get("TOKEN_" + token);
        User user = JSON.parseObject(jsonString, User.class);
        Long userId  = user==null?null:user.getId();
        ArticleVo articleVo = articleDao.viewById(id,userId);
        Long authorId = articleVo.getAuthorId();
        boolean followed = followService.isFollowed(userId, authorId);
        articleVo.setIsFollowed(followed?1:0);
        return Result.success(articleVo);
    }
}
