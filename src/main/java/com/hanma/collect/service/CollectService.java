package com.hanma.collect.service;

import com.hanma.collect.domain.Collect;
import com.hanma.commons.ResultMsg;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface CollectService {
    //新增收藏
    ResultMsg saveCollect(Collect collect);

    //根据用户ID查询收藏记录
    List<Collect> queryUserIdCollect(Long userId);
}
