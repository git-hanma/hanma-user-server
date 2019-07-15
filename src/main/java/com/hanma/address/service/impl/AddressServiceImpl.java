package com.hanma.address.service.impl;

import com.hanma.address.domain.Address;
import com.hanma.address.mapper.AddressMapper;
import com.hanma.address.service.AddressService;
import com.hanma.commons.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    /**
     * 注入 address mapper层
     */
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 根据用户ID查询所有地址
     * @param userId
     * @param addressId
     * @return
     */
    @Override
    public DataGrid queryUserIdAddress(Long userId, Long addressId) {
        DataGrid db = new DataGrid();

        List<Address> addressList = addressMapper.queryUserIdAddress(userId,addressId);
        db.setRows(addressList);
        return db;
    }
}