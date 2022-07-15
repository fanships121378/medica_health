package com.fanship.service;

import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.entity.Result;
import com.fanship.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public Result deleteCode(String code);
    public void update(CheckItem checkItem);

    List<CheckItem> findAll();
}
