package com.fanship.dao;

import com.fanship.pojo.CheckGroup;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

public interface CheckGroupDao {
    public void insert(CheckGroup checkGroup);
    public void SetCHeckGroupAndCHeckItem(Integer checkGroupId,Integer checkItemId);

    Page<CheckGroup> selectByCondition(String queryString);
}
