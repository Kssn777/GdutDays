package com.lrh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lrh.dao.ArticleLikesDao;
import com.lrh.entity.ArticleLikes;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.service.LikesService;
import com.lrh.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrh
 * @description
 * @date 2023/2/24
 */
@Service
public class LikesServiceImpl implements LikesService {


    @Autowired
    private ArticleLikesDao articleLikesDao;

    /**
     * 该方法会先被拦截器拦截再到这里，因此ThreadLocal会有用户信息
     * @return
     */
    @Override
    public Result getLikes() {
        User user = UserThreadLocal.get();
        Long userId = user.getId();
        LambdaQueryWrapper<ArticleLikes> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleLikes::getUserId,userId);
        List<ArticleLikes> articleLikes = articleLikesDao.selectList(wrapper);
        return Result.success(articleLikes);
    }
}
