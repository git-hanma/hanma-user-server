package com.hanma.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zhaoyumeng on 2019/7/15.
 * 用户表
 */
@Data
public class User {

    //用户主键
    private Long userId;

    //商家外键
    private Long merchantId;

    //用户手机号
    private String  userPhone;

    //用户密码
    private String  userPass;

    //用户名称
    private String  userName;

    //用户头像
    private String  userImg;

    //用户性别
    private Integer  userSex;

    //注册时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  userCreateTime;

    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  userUpdateTime;

    //状态
    private Integer  userYn;


}
