package com.hanma.comment.service;

import com.hanma.comment.domain.Comment;
import com.hanma.commons.ResultMsg;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface CommentService {

    //新增评论
    ResultMsg saveComment(Comment comment);

    //根据商家ID查询评论
    List<Comment> queryMerchantIdComment(Long merchantId);
}
