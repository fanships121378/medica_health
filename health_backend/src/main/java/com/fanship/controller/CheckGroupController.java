package com.fanship.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fanship.common.MessageContant;
import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.entity.Result;
import com.fanship.pojo.CheckGroup;
import com.fanship.service.CheckGroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    public CheckGroupService checkGroupService;

    @PostMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try{
            checkGroupService.addGroup(checkGroup,checkitemIds);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageContant.ADD_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageContant.ADD_CHECKITEM_SUCCESS);
    }
    @RequestMapping("/find_page")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return checkGroupService.pageQuery(queryPageBean);
    }
}
