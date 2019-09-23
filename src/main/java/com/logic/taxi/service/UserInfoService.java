package com.logic.taxi.service;


import com.logic.taxi.model.UserInfo;

/**
 * @author 张瑶
 * @Description:
 * @time 2018/4/18 11:56
 */
public interface UserInfoService {

    UserInfo selectById(Integer id);

}