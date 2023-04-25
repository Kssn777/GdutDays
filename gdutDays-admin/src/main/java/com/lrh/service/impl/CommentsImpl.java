package com.lrh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.dao.CommentsDao;
import com.lrh.entity.Comments;
import com.lrh.entity.Result;
import com.lrh.entity.param.CommentParam;
import com.lrh.entity.vo.CommentsVo;
import com.lrh.service.CommentsService;
import com.lrh.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lrh
 * @description
 * @date 2023/3/18
 */
@Service
public class CommentsImpl implements CommentsService {

    private static final int DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public Result showComments(Long articleId,int page) {
        Page<CommentsVo> commentsVoPage = new Page<>(page,DEFAULT_PAGE_SIZE);
        IPage<CommentsVo> commentsVoIPage = commentsDao.showComments(commentsVoPage,articleId);
        return Result.success(commentsVoIPage);
    }


    @Override
    @Transactional
    public Result addComments(CommentParam commentParam){
        Long articleId = commentParam.getArticleId();
        String content = commentParam.getContent();
        Long toUserId = commentParam.getToUserId() == null?-1:commentParam.getToUserId();
        Long UserId = UserThreadLocal.get().getId();



        Comments comments = new Comments();
        comments.setArticleId(articleId);
        comments.setComments(content);
        comments.setTouserId(toUserId);

        comments.setCreateDate(System.currentTimeMillis()/1000);
        comments.setUserId(UserId);

        commentsDao.insert(comments);

        commentsDao.updateCommentsCounts(articleId);

        return Result.success(null);

    }
}
