package com.hanma.user.service.impl;

import com.hanma.commons.DataGrid;
import com.hanma.commons.ImgUtil;
import com.hanma.commons.MD5;
import com.hanma.commons.RandomNumUtil;
import com.hanma.commons.RedisUtil;
import com.hanma.commons.ResultMsg;
import com.hanma.user.domain.User;
import com.hanma.user.mapper.UserMapper;
import com.hanma.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;


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

    //redis缓存工具类
    @Autowired
    private RedisUtil redisUtil;






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
     * 根据ID修改
     * @param user
     * @return
     */
    @Override
    public ResultMsg updateUser(User user) {
        ResultMsg  resultMsg = new ResultMsg();
        user.setUserUpdateTime(new Date());
        try {
            userMapper.updateUser(user);
            resultMsg.setMsg("修改成功");
            resultMsg.setCode(200);
        }catch (Exception e){
            resultMsg.setMsg("修改失败  出现未知错误");
            resultMsg.setCode(500);
            resultMsg.setSuccessFalse();
        }
        return resultMsg;
    }


    /**
     * 查询所有用户
     * @return
     */
    @Override
    public DataGrid queryUserList() {
        DataGrid db = new DataGrid();

        List<User> userList = userMapper.queryUserList();
        db.setRows(userList);
        return db;
    }

    /**
     * 根据用户ID查询商家ID是否存在
     * @param userId
     * @return
     */
    @Override
    public Long getUserIdMerchantId(Long userId) {
        return userMapper.getUserIdMerchantId(userId);
    }



    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public ResultMsg loginUser(User user,String code) {
        //创建
        ResultMsg rs = new ResultMsg();
        //将密码放到MD5加密
        String md5 = MD5.md5(user.getUserPass());
        //讲加密完的密码 放到对象中取数据库查询
        user.setUserPass(md5);
        //生成key把key放到缓存里
        String key = "user";
        //根据手机号 和密码 进行数据库匹配  select * from t_customer where cu_phoone = and cu_pass =
        User dbUser = userMapper.loginUser(user);

        if(dbUser!=null){
            //判断key是否存在 存在返回true 不存在返回false
            boolean exists = redisUtil.exists(key);
            if (exists) {
                long start = System.currentTimeMillis();
                //如果缓存存在直接在缓存中取
                Object o = redisUtil.get(key);
                System.out.println("==========从缓存中获得数据========="+o);
                System.out.println("==============================");
                long end = System.currentTimeMillis();
                System.out.println("查询redis花费的时间是:" + (end - start) + "s");
              /* redisUtil.remove(key);*/
            } else {
                long start = System.currentTimeMillis();
                System.out.println("==========从数据表中获得数据=========");
                //如果查到数据  讲数据放到缓存中
                redisUtil.set(key, dbUser);
                //设置缓存时间
                redisUtil.expire(key,60*30L);
                long end = System.currentTimeMillis();
                System.out.println("查询mysql花费的时间是:" + (end - start) + "s");

            }
        }else if(dbUser == null){
            rs.setCode(500);
            rs.setMsg(" 手机号 或者 密码错误 请修改后重试");
            return rs;
        }
        rs.setCode(200);
        rs.setMsg("恭喜您 登录成功!!!");
        return rs;
    }

    /**
     * 从缓存中获取
     * @return
     */
    @Override
    public Object gainRedisData() {
        Object user = redisUtil.get("user");
        return user;
    }

    /**
     * 从缓存中删除
     */
    @Override
    public void quitRedis() {
        redisUtil.remove("user");
    }

    @Override
    public ResultMsg sendPhoneCode(HttpServletRequest request, String cuPhone) {
        return null;
    }

    @Override
    public ResultMsg checkPhone(User user) {
        return null;
    }
}
