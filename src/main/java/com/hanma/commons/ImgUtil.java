package com.hanma.commons;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by zhaoyumeng on 2019/7/23.
 */
public class ImgUtil {

    //图片验证码宽度
    private static final Integer WIDTH = 120;
    //图片验证码高度
    private static final Integer HEIGHT = 30;


    public String getImg(HttpServletRequest request, HttpServletResponse response) {
        BufferedImage image=new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();
        RandomNumUtil.setBackground(g,WIDTH,HEIGHT);//1.设置背景色
        RandomNumUtil.setBorder(g,WIDTH,HEIGHT);//2.生成边界
        RandomNumUtil.drawRandomLine(g,WIDTH,HEIGHT);//3.画几条随机干扰线

        //String num=RandomNumUtil.drawRandomCh((Graphics2D) g);//4.生成几个随机汉字，需设置编码gbk，不然会抛异常
        //String num = RandomNumUtil.getChAndNumStr((Graphics2D) g);
        // num=URLEncoder.encode(num,"gbk");

        //int num=drawNum((Graphics2D) g);//随机生成几个数字

        String num= RandomNumUtil.drawNums((Graphics2D) g);//随机生成几个数字或字母

        //将字符串的验证码保存到session中 便于后期校验
        request.getSession().setAttribute("codeImg",num);
        //5.图形写给浏览器
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("utf8");
        //控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma","no-cache");

        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}
