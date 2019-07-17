package com.hanma.address.service;

import com.hanma.address.domain.Address;
import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface AddressService {
    //根据用户ID查询所有地址
    DataGrid queryUserIdAddress(Long userId, Long addressId);

    //新增地址
    ResultMsg saveAddress(Address address);
}
