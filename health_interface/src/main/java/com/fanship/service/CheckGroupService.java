package com.fanship.service;

import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.pojo.CheckGroup;

public interface CheckGroupService {
    public void addGroup(CheckGroup checkGroup,Integer[] checkIds);

    PageResult pageQuery(QueryPageBean queryPageBean);
}
