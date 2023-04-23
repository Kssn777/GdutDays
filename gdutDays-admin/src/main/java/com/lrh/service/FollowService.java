package com.lrh.service;

import com.lrh.entity.Result;
import com.lrh.entity.param.FollowParam;

public interface FollowService {

    Result getCurrentFollowList(int page);

    Result getFollowListById(Long id,int page);

    Result getCurrentFansList(int page);

    Result getFansListById(Long id,int page);

    boolean isFollowed(Long aid,Long bid);

    Result followOperation(FollowParam followParam);
}
