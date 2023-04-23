package com.lrh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.dao.UserFollowDao;
import com.lrh.entity.Result;
import com.lrh.entity.User;
import com.lrh.entity.UserFollow;
import com.lrh.entity.param.FollowParam;
import com.lrh.entity.vo.UserFollowVo;
import com.lrh.service.FollowService;
import com.lrh.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrh
 * @description
 * @date 2023/3/26
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private UserFollowDao userFollowDao;

    private static final int DEFAULT_SIZE = 10;


    @Override
    public Result getCurrentFollowList(int page) {
        User user = UserThreadLocal.get();
        Long id = user.getId();

        return getFollowListById(id,page);
    }

    @Override
    public Result getFollowListById(Long id,int page) {

        IPage<UserFollowVo> followListById = userFollowDao.getFollowListById(new Page<UserFollowVo>(page,DEFAULT_SIZE),id);
        return Result.success(followListById);
    }

    @Override
    public Result getCurrentFansList(int page) {
        User user = UserThreadLocal.get();
        Long id = user.getId();
        return getFansListById(id,page);
    }

    @Override
    public Result getFansListById(Long id,int page) {
        IPage<UserFollowVo> fansListById = userFollowDao.getFansListById(new Page<UserFollowVo>(page, DEFAULT_SIZE), id);
        return Result.success(fansListById);
    }

    /**
     * 看a用户是否关注了b用户
     * @param aid
     * @param bid
     * @return
     */
    @Override
    public boolean isFollowed(Long aid,Long bid){
        LambdaQueryWrapper<UserFollow> wrapper = new LambdaQueryWrapper<UserFollow>();
        wrapper.eq(UserFollow::getUserId,aid)
                .eq(UserFollow::getFollowId,bid);
        UserFollow userFollow = userFollowDao.selectOne(wrapper);
        return userFollow != null;
    }

    @Override
    //TODO 在表上建立userId和followId的联合索引 方便做取关关注操作
    public Result followOperation(FollowParam followParam) {
        User user = UserThreadLocal.get();
        Long userId = user.getId();
        Long followId = followParam.getTargetId();
        int op = followParam.getOp();
        if(op == 1){
            UserFollow userFollow = new UserFollow();
            userFollow.setFollowId(followId);
            userFollow.setUserId(userId);
            userFollowDao.insert(userFollow);
        }else{
            userFollowDao.delete(new LambdaQueryWrapper<UserFollow>().eq(UserFollow::getUserId,userId).eq(UserFollow::getFollowId,followId));
        }
        return Result.success(null);
    }
}
