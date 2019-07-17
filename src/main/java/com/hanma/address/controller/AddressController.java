package com.hanma.address.controller;

import com.hanma.address.domain.Address;
import com.hanma.address.service.AddressService;
import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
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
@RequestMapping("/address")
public class AddressController {

    /**
     * 注入address service层
     */
    @Autowired
    private AddressService addressService;


    /**
     * 根据用户ID查询所有地址
     * @param userId
     * @param addressId
     * @return
     */
    @ApiOperation(value = "根据用户ID查询所有地址接口")
    @GetMapping("/queryUserIdAddress")
    @ResponseBody
    public DataGrid queryUserIdAddress(Long userId,Long addressId){
        return addressService.queryUserIdAddress(userId,addressId);
    }


    /**
     * 新增地址接口
     * @param address
     * @return
     */
    @ApiOperation(value = "新增地址接口")
    @PostMapping
    @ResponseBody
    public ResultMsg saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }


}
