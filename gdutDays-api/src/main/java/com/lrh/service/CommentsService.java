package com.lrh.service;

import com.lrh.entity.Result;
import com.lrh.entity.param.CommentParam;

public interface CommentsService {

    Result showComments(Long articleId,int page);


    Result addComments(CommentParam commentParam);

    Result deleteComments(Long id);
}
