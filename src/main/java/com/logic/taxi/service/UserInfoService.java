package com.logic.taxi.service;


import com.logic.taxi.entity.UserInfo;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:56
 */
public interface UserInfoService {

    UserInfo selectById(Integer id);

}