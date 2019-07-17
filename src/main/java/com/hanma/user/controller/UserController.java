package com.hanma.user.controller;

import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
import com.hanma.user.domain.User;
import com.hanma.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
@RequestMapping("/user")
@Api(description = "用户相关接口接口")
public class UserController {

    /**
     * 注入userService
     */
    @Autowired
    private UserService userService;




    /**
     * 根据用户ID查询接口
     * @param userId
     * @return
     */
    @GetMapping("/getUserId")
    @ResponseBody
    @ApiOperation(value = "根据用户ID查询接口")
    public User getUserId(Long userId){
        return userService.getUserId(userId);
    }

    /**
     * 根据ID修改接口
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    @ResponseBody
    @ApiOperation(value = "根据ID修改接口")
    public ResultMsg updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
