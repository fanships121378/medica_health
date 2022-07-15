package com.fanship.dao;

import com.fanship.pojo.CheckItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem item);
    public Page<CheckItem> selectByCondition(@Param("queryString") String queryString);
    public void deleteItem(String id);
    public Integer findCountByItemId(String id);
    void updateItem(CheckItem checkItem);

    List<CheckItem> findAll();
}
