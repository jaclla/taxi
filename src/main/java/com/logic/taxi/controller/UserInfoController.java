package com.logic.taxi.controller;

import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.model.UserInfo;
import com.logic.taxi.service.UserInfoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张瑶
 * @Description:
 * @time 2018/4/18 11:39
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

  @Resource
  private UserInfoService userInfoService;

  @PostMapping("/hello")
  public String hello() {
    return "hello SpringBoot";
  }

  @PostMapping("/selectById")
  public RetResult<UserInfo> selectById(Integer id) {
    UserInfo userInfo = userInfoService.selectById(id);
    return RetResponse.makeOKRsp(userInfo);
  }

  @PostMapping("/testException")
  public RetResult<UserInfo> testException(Integer id){
    List a = null;
    a.size();
    UserInfo userInfo = userInfoService.selectById(id);
    return RetResponse.makeOKRsp(userInfo);
  }

}