package com.hanma.user.mapper;

import com.hanma.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface UserMapper {
    //根据用户ID查询信息
    User getUserId(Long userId);

    //根据ID修改
    void updateUser(User user);

    //查询所有用户
    List<User> queryUserList();
}
