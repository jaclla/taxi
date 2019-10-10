package com.logic.taxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.entity.UserInfo;

public interface UserInfoService extends IService<UserInfo> {


  RetResult login(UserInfo userInfo);
}
