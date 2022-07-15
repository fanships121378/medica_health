package com.fanship.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fanship.common.MessageContant;
import com.fanship.dao.CheckItemDao;
import com.fanship.entity.PageResult;
import com.fanship.entity.QueryPageBean;
import com.fanship.entity.Result;
import com.fanship.pojo.CheckItem;
import com.fanship.service.CheckItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
         checkItemDao.add(checkItem);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckItem> checkItems = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(checkItems.getTotal(),checkItems.getResult());
    }

    @Override
    public Result deleteCode(String code){
         if (checkItemDao.findCountByItemId(code)!=null){
             return new Result(false, "此检查项已被引用，请先解除引用");
         }
        checkItemDao.deleteItem(code);
         return new Result(true,MessageContant.DELETE_CHECKITEM_SUCCESS);
    }

    @Override
    public void update(CheckItem checkItem) {
        checkItemDao.updateItem(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
       return checkItemDao.findAll();
    }
}
