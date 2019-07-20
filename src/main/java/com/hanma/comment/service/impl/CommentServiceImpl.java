package com.hanma.comment.service.impl;

import com.hanma.comment.domain.Comment;
import com.hanma.comment.mapper.CommentMapper;
import com.hanma.comment.service.CommentService;
import com.hanma.commons.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
public class CommentServiceImpl implements CommentService {

    /**
     * 注入mapper接口
     */
    @Autowired
    private CommentMapper commentMapper;



    /**
     * 新增评论
     * @param comment
     * @return
     */
    @Override
    public ResultMsg saveComment(Comment comment) {
        ResultMsg rs = new ResultMsg();
        comment.setCommentCreateTime(new Date());
        comment.setCommentYn(1);
        try{
            commentMapper.saveComment(comment);
            rs.setMsg("新增成功");
            rs.setCode(200);
        }catch (Exception e){
            System.out.println(e);
            rs.setMsg("新增失败");
            rs.setCode(500);
            rs.setSuccessFalse();
        }

        return rs;

    }

    /**
     * 根据商家ID查询评论
     * @param merchantId
     * @return
     */
    @Override
    public List<Comment> queryMerchantIdComment(Long merchantId) {
        return commentMapper.queryMerchantIdComment(merchantId);
    }
}
