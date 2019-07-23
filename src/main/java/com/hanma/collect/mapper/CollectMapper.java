package com.hanma.collect.mapper;

import com.hanma.collect.domain.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface CollectMapper {
    //新增收藏
    void saveCollect(Collect collect);

    //根据用户ID查询收藏记录
    List<Collect> queryUserIdCollect(@Param("userId") Long userId);

    //根据收藏ID删除
    void delCollectId(@Param("collectId") Long collectId, @Param("yn") int yn, @Param("collectUpdateTime") Date date);
}
