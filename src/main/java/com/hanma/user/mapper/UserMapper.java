package com.hanma.user.mapper;

import com.hanma.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface UserMapper {
    //根据用户ID查询信息
    User getUserId(Long userId);

    //根据ID修改密码
    void updateUserPass(@Param("userId") Long userId, @Param("userPass") String userPass);

}
