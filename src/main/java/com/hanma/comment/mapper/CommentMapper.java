package com.hanma.comment.mapper;

import com.hanma.comment.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface CommentMapper {
    //新增地址
    void saveComment(Comment comment);

    //根据商家ID查询所有评论
    List<Comment> queryMerchantIdComment(Long merchantId);
}
