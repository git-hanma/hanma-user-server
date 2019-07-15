package com.hanma.user.service;

import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
import com.hanma.user.domain.User;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface UserService {
    //根据用户ID查询接口
    User getUserId(Long userId);

    //根据ID修改密码接口
    ResultMsg updateUserPass(Long userId, String userPass);

}
