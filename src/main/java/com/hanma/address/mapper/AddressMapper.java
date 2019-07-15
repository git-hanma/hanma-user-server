package com.hanma.address.mapper;

import com.hanma.address.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface AddressMapper {

    //根据用户ID查询所有地址
    List<Address> queryUserIdAddress(@Param("userId") Long userId, @Param("addressId") Long addressId);




}
