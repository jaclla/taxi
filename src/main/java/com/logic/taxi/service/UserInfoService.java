package com.logic.taxi.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.UserInfo;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:56
 */
public interface UserInfoService extends IService<UserInfo> {

  RetResult selectById(Integer id);

  RetResult selectList();

  RetResult selectPage(Page<UserInfo> iPage);

  RetResult insert(String name);


}
