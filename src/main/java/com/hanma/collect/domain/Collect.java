package com.hanma.collect.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zhaoyumeng on 2019/7/15.
 * 收藏表
 */
@Data
public class Collect {

    //收藏主键
    private Long collectId;
    //商家主键
    private Long merchantId;
    //用户主键
    private Long userId;
    //新增时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collectCreateTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collectUpdateTime;
    //状态
    private Integer collectYn;
}
