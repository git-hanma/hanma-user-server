package com.hanma.collect.controller;

import com.hanma.collect.domain.Collect;
import com.hanma.collect.service.CollectService;
import com.hanma.commons.ResultMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
@RequestMapping("collect")
@Api(description = "收藏接口")
public class CollectController {

    /**
     * 注入service 层
     */
    @Autowired
    private CollectService collectService;


    /**
     * 新增收藏接口
     * @param collect
     * @return
     */
    @ApiOperation(value = "新增收藏接口")
    @PostMapping("/saveCollect")
    @ResponseBody
    public ResultMsg saveCollect(Collect collect){
        return collectService.saveCollect(collect);
    }


    /**
     * 根据用户ID查询收藏记录
     * @param userId
     * @return
     */
    @ApiOperation(value = "根据用户ID查询收藏接口")
    @GetMapping("/queryUserIdCollect")
    @ResponseBody
    public List<Collect> queryUserIdCollect(Long userId){
        return collectService.queryUserIdCollect(userId);
    }

}
