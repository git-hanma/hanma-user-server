package com.hanma.comment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zhaoyumeng on 2019/7/15.
 * 评价表
 */
@Data
public class Comment {

    //评价主键
    private Long commentId;
    //用户外键
    private Long userId;
    //商家外键
    private Long merchantId;
    //用户手机号
    private String  userPhone;
    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentCreateTime;
    //评价
    private Integer  commentDiscuss;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentUpdateTime;
    //状态
    private Integer commentYn;
}
