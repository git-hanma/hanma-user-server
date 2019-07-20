package com.hanma.comment.controller;

import com.hanma.comment.domain.Comment;
import com.hanma.comment.service.CommentService;
import com.hanma.commons.ResultMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
@RequestMapping("/comment")
@Api(description = "评论接口")
public class CommentController {

    /**
     * 注入service 接口
     */
    @Autowired
    private CommentService commentService;


    /**
     * 新增评论
     * @param comment
     * @return
     */
    @ApiOperation(value = "新增评论接口")
    @PostMapping("/saveComment")
    @ResponseBody
    public ResultMsg saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }


    /**
     * 根据商家ID查询所有评论
     * @param merchantId
     * @return
     */
    @ApiOperation(value = "根据商家ID查询所有评论")
    @GetMapping("/queryMerchantIdComment")
    @ResponseBody
    public List<Comment> queryMerchantIdComment(Long merchantId){
        return commentService.queryMerchantIdComment(merchantId);
    }

}
