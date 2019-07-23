package com.hanma.user.service;

import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
import com.hanma.user.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface UserService {
    //根据用户ID查询接口
    User getUserId(Long userId);

    //根据ID修改密码接口
    ResultMsg updateUser(User user);

    //查询所有订单接口
    DataGrid queryUserList();

    //根据用户ID查询商家ID是否存在
    Long getUserIdMerchantId(Long userId);

    //登录
    ResultMsg loginUser(User user,String code);
}
