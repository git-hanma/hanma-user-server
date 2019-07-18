package com.hanma.address.mapper;

import com.hanma.address.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface AddressMapper {

    //根据用户ID查询所有地址
    List<Address> queryUserIdAddress(Long userId);

    //新增地址
    void saveAddress(Address address);

    //根据ID删除
    void delAddressId(@RequestParam("addressId") Long addressId,@RequestParam("addressYn") Integer yn);

    //根据ID查询
    Address getAddressId(Long addressId);

}
