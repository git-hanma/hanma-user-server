package com.hanma.address.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zhaoyumeng on 2019/7/15.
 * 地址表
 */
@Data
public class Address {

    //地址主键
    private Long addressId;
    //用户外键
    private Long userId;
    //联系手机号
    private String addressPhone;
    //收货人
    private String  addressName;
    //省
    private String  addressProvince;
    //市
    private String  addressCity;
    //县
    private String  addressCounty;
    //详细收货地址
    private String  addressShipping;
    //新增时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addressCreateTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  addressUpdateTime;
    //状态
    private Integer addressYn;
}
