package com.logic.taxi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.core.ret.ServiceException;
import com.logic.taxi.mapper.UserInfoMapper;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.service.UserInfoService;
import java.util.List;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:56
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

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

    @Override
    public List<UserInfo> selectList() {
        List<UserInfo> userInfos = userInfoMapper.selectList(null);
        return userInfos;
    }

    @Override
    public IPage<UserInfo> selectPage(Page<UserInfo> iPage) {
        return userInfoMapper.selectPage(iPage, new QueryWrapper<>());
    }


}