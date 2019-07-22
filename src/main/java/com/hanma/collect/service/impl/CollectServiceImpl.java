package com.hanma.collect.service.impl;

import com.hanma.collect.domain.Collect;
import com.hanma.collect.mapper.CollectMapper;
import com.hanma.collect.service.CollectService;
import com.hanma.commons.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
public class CollectServiceImpl implements CollectService {


    /**
     * 注入 mapper 层
     */
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 新增收藏
     * @param collect
     * @return
     */
    @Override
    public ResultMsg saveCollect(Collect collect) {
        ResultMsg rs = new ResultMsg();
        collect.setCollectCreateTime(new Date());
        collect.setCollectYn(1);
        try{
            collectMapper.saveCollect(collect);
            rs.setMsg("收藏成功");
            rs.setCode(200);
        }catch (Exception e){
            rs.setMsg("收藏失败");
            rs.setCode(500);
            rs.setSuccessFalse();
        }
        return rs;
    }

    /**
     * 根据用户ID查询收藏记录
     * @param userId
     * @return
     */
    @Override
    public List<Collect> queryUserIdCollect(Long userId) {
        return collectMapper.queryUserIdCollect(userId);
    }
}
