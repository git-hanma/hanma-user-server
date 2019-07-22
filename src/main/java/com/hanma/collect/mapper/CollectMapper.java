package com.hanma.collect.mapper;

import com.hanma.collect.domain.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
public interface CollectMapper {
    //新增收藏
    void saveCollect(Collect collect);

    //根据用户ID查询收藏记录
    List<Collect> queryUserIdCollect(Long userId);
}
