package com.hanma.user.controller;

import com.google.gson.Gson;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
@RequestMapping("/user")
@Api(description = "用户接口")
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

    /**
     * 根据用户ID查询商家ID是否存在
     * @param userId
     * @return
     */
    @GetMapping("/getUserIdMerchantId")
    @ApiOperation(value = "根据用户ID查询商家ID是否存在接口")
    @ResponseBody
    public Long getUserIdMerchantId(Long userId){
        return userService.getUserIdMerchantId(userId);
    }


    /**
     * 登录方法
     * @param user
     * @return
     */
    @GetMapping(value = "/loginUser")
    @ApiOperation(value = "登录方法 接口")
    @ResponseBody
    public ResultMsg loginUser(String user,String code){
        Gson gson = new Gson();
        User json = gson.fromJson(user, User.class);
        return userService.loginUser(json,code);
    }

    /**
     * 验证手机号是否存在
     * @param user
     * @return

    @GetMapping(value = "/checkPhone")
    @ApiOperation(value = "验证手机号 接口")
    @ResponseBody
    public ResultMsg  checkPhone(User user){
        return userService.checkPhone(user);
    }*/


    /**
     * 注册方法
     * @param user
     * @return

    @GetMapping(value = "saveCustomer")
    @ApiOperation(value = "注册方法 接口")
    @ResponseBody
    public ResultMsg saveCustomer(HttpServletRequest request, String code , User user){
        return userService.saveCustomer(request,user,code);
    }*/


    /**
     * 发送手机验证码
     * @param request
     * @param cuPhone
     * @return

    @GetMapping("/sendPhoneCode")
    @ApiOperation(value = "发送手机验证码  接口")
    @ResponseBody
    public ResultMsg sendPhoneCode(HttpServletRequest request, String cuPhone){
        return  userService.sendPhoneCode(request,cuPhone);
    }*/


    /**
     * 从缓存中取数据
     * @return

    @GetMapping("/gainRedisData")
    @ApiOperation(value = "从缓存中取数据")
    @ResponseBody
    public Object gainRedisData(){
        return userService.gainRedisData();
    }*/

    /**
     * 从缓存中删除

    @GetMapping("/quitRedis")
    @ApiOperation(value = "从缓存中删除")
    @ResponseBody
    public void quitRedis(){
        userService.quitRedis();
    }*/

}
