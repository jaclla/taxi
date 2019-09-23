package com.logic.taxi.service.impl;

import com.logic.taxi.core.ret.ServiceException;
import com.logic.taxi.dao.UserInfoMapper;
import com.logic.taxi.model.UserInfo;
import com.logic.taxi.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:56
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer id){
        UserInfo userInfo = userInfoMapper.selectById(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

}