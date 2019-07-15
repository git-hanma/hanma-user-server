package com.hanma.user.service.impl;

import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
import com.hanma.user.domain.User;
import com.hanma.user.mapper.UserMapper;
import com.hanma.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 注入userMapper 层
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户ID查询
     * @param userId
     * @return
     */
    @Override
    public User getUserId(Long userId) {
        return userMapper.getUserId(userId);
    }

    /**
     * 根据ID修改密码
     * @param userId
     * @param userPass
     * @return
     */
    @Override
    public ResultMsg updateUserPass(Long userId, String userPass) {
        ResultMsg  resultMsg = new ResultMsg();

        try {
            userMapper.updateUserPass(userId,userPass);
            resultMsg.setMsg("修改成功");
            resultMsg.setCode(200);
        }catch (Exception e){
            resultMsg.setMsg("修改失败  出现未知错误");
            resultMsg.setCode(500);
            resultMsg.setSuccessFalse();
        }
        return resultMsg;
    }



}
