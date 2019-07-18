package com.hanma.address.service.impl;

import com.hanma.address.domain.Address;
import com.hanma.address.mapper.AddressMapper;
import com.hanma.address.service.AddressService;
import com.hanma.commons.DataGrid;
import com.hanma.commons.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
     * @return
     */
    @Override
    public List<Address> queryUserIdAddress(Long userId) {
        List<Address> addressList = addressMapper.queryUserIdAddress(userId);
        return addressList;
    }

    /**
     * 新增地址
     * @param address
     * @return
     */
    @Override
    public ResultMsg saveAddress(Address address) {
        ResultMsg rs = new ResultMsg();
        address.setAddressCreateTime(new Date());
        address.setAddressYn(1);
        try{
            addressMapper.saveAddress(address);
            rs.setMsg("新增成功");
            rs.setCode(200);
        }catch (Exception e){
            System.out.println(e);
            rs.setCode(500);
            rs.setMsg("新增失败");
            rs.setSuccessFalse();
        }
        return rs;
    }

    /**
     * 根据ID删除
     * @param addressId
     * @return
     */
    @Override
    public ResultMsg delAddressId(Long addressId) {
        ResultMsg rs = new ResultMsg();
        Integer yn = 0;
        try{
            addressMapper.delAddressId(addressId,yn);
            rs.setCode(200);
            rs.setMsg("删除成功");
        }catch (Exception e){
            System.out.println(e);
            rs.setCode(500);
            rs.setMsg("删除失败");
            rs.setSuccessFalse();
        }
        return rs;
    }

    /**
     * 根据ID查询
     * @param addressId
     * @return
     */
    @Override
    public Address getAddressId(Long addressId) {
        return addressMapper.getAddressId(addressId);
    }
}
