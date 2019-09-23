package com.logic.taxi.dao;

import com.logic.taxi.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张瑶
 * @Description:
 * @time 2018/4/18 11:54
 */
public interface UserInfoMapper {

    UserInfo selectById(@Param("id") Integer id);
}
