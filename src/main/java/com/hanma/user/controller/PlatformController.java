package com.hanma.user.controller;

import com.hanma.commons.DataGrid;
import com.hanma.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoyumeng on 2019/7/16.
 */
@Controller
@RequestMapping("/platform")
@ApiOperation(value = "平台调用服务 接口")
public class PlatformController {


    /**
     * 注入userService
     */
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户接口
     * @return
     */
    @ApiOperation(value = "查询所有用户接口")
    @GetMapping("/queryUserList")
    @ResponseBody
    public DataGrid queryUserList(){
        return userService.queryUserList();
    }

}
