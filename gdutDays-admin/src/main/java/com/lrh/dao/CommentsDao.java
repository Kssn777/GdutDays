package com.lrh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrh.entity.Comments;
import com.lrh.entity.vo.CommentsVo;
import org.apache.ibatis.annotations.Update;

public interface CommentsDao extends BaseMapper<Comments> {
    IPage<CommentsVo> showComments(Page<CommentsVo> commentsVoPage, Long articleId);

    @Update("update article set comment_counts = comment_counts+1 where id = #{articleId}")
    void updateCommentsCounts(Long articleId);

}
