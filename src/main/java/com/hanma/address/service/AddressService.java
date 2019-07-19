package com.hanma.address.service;

import com.hanma.address.domain.Address;
import com.hanma.commons.ResultMsg;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface AddressService {
    //根据用户ID查询所有地址
    List<Address> queryUserIdAddress(Long userId);

    //新增地址
    ResultMsg saveAddress(Address address);

    //根据ID删除
    ResultMsg delAddressId(Long addressId);

    //根据ID查询
    Address getAddressId(Long addressId);

    //修改地址
    ResultMsg updateAddress(Address address);
}
