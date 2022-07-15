package com.fanship.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fanship.common.MessageContant;
import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.entity.Result;
import com.fanship.pojo.CheckItem;
import com.fanship.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference //查找服务
    private CheckItemService checkItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){

        try {
            checkItemService.add(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageContant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageContant.ADD_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/find_page")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.pageQuery(queryPageBean);
        return pageResult;
    }
    @DeleteMapping("/delete/id")
    public Result delete_code( String id){
        System.out.println(id);
        if (!(id == null || id.length()<2)) {
            return checkItemService.deleteCode(id);
        }
        return new Result(false,MessageContant.DELETE_CHECKITEM_FAIL);
    }
    @PostMapping("/update_item")
    public Result update_item(@RequestBody CheckItem item){
        try{
            checkItemService.update(item);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageContant.EDIT_CHECKITEM_FAIL);
        }
        return new Result(true,MessageContant.EDIT_CHECKITEM_SUCCESS);
    }
    @GetMapping("/find_all")
    public Result findAll(){
        List<CheckItem> checkItemList= checkItemService.findAll();
        if (checkItemList!=null && checkItemList.size()>0){
            Result result = new Result(true, MessageContant.QUERY_CHECKITEM_SUCCESS);
            result.setData(checkItemList);
            return result;
        }
        return new Result(false,MessageContant.QUERY_CHECKITEM_FAIL);
    }
}
