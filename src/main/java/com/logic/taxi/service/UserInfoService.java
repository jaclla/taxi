package com.logic.taxi.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.UserInfo;
import java.util.List;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:56
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo selectById(Integer id);

    List<UserInfo> selectList();

    IPage<UserInfo> selectPage(Page<UserInfo> iPage);

}