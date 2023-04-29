package com.lrh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.entity.UserFollow;
import com.lrh.entity.vo.ArticleVo;
import com.lrh.entity.vo.UserFollowVo;

public interface UserFollowDao extends BaseMapper<UserFollow> {
    IPage<UserFollowVo> getFollowListById(Page<UserFollowVo> page, Long id);

    IPage<UserFollowVo> getFansListById(Page<UserFollowVo> page, Long id);
}
