package com.logic.taxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.mapper.UserInfoMapper;
import com.logic.taxi.service.UserInfoService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements
    UserInfoService {

  @Resource
  private UserInfoMapper userInfoMapper;

  @Override
  public RetResult login(UserInfo userInfo) {
    UserInfo user = userInfoMapper.selectById(userInfo.getId());
    if (user == null) {
      return RetResponse.makeOKRsp(userInfoMapper.insert(userInfo));
    } else {
      return RetResponse.makeOKRsp(userInfoMapper.updateById(userInfo));
    }
  }
}
