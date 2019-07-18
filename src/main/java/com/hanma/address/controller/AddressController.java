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

import java.util.List;

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
     * @return
     */
    @ApiOperation(value = "根据用户ID查询所有地址接口")
    @GetMapping("/queryUserIdAddress")
    @ResponseBody
    public List<Address> queryUserIdAddress(Long userId){
        return addressService.queryUserIdAddress(userId);
    }


    /**
     * 新增地址接口
     * @param address
     * @return
     */
    @ApiOperation(value = "新增地址接口")
    @PostMapping("/saveAddress")
    @ResponseBody
    public ResultMsg saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    /**
     * 根据ID删除
     * @param addressId
     * @return
     */
    @ApiOperation(value = "根据ID删除")
    @PostMapping("/delAddressId")
    @ResponseBody
    public ResultMsg delAddressId(Long addressId){
        return addressService.delAddressId(addressId);
    }

    /**
     * 根据ID查询
     * @param addressId
     * @return
     */
    @ApiOperation(value = "根据ID查询")
    @GetMapping("/getAddressId")
    @ResponseBody
    public Address getAddressId(Long addressId){
        return addressService.getAddressId(addressId);
    }

}
