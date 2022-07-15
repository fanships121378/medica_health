package com.fanship.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fanship.dao.CheckGroupDao;
import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.pojo.CheckGroup;
import com.fanship.service.CheckGroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public void addGroup(CheckGroup checkGroup, Integer[] checkIds) {
         checkGroupDao.insert(checkGroup);
        for (Integer checkId : checkIds) {
            checkGroupDao.SetCHeckGroupAndCHeckItem(checkGroup.getId(),checkId);
        }
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckGroup> result = checkGroupDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(result.getTotal(),result.getResult());
    }
}
