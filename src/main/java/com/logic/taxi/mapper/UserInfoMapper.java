package com.logic.taxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logic.taxi.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:54
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo selectById(@Param("id") Integer id);
}
