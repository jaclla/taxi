package com.logic.taxi.controller;

import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.service.TaxiInfoService;
import com.logic.taxi.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Api(tags = {"权限认证"}, description = "UserInfoControler")
public class UserInfoController {

  @Resource
  private UserInfoService userInfoService;

  @ApiOperation(value = "登录", notes = "登录")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "id",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "authDate", value = "权限时期",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "firstName", value = "姓",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "lastName", value = "名",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "hash", value = "哈希",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "photoUrl", value = "头像图片",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "userName", value = "用户名",
          dataType = "String", paramType = "query")
  })
  @PostMapping("/login")
  public RetResult login(UserInfo userInfo) {
    return userInfoService.login(userInfo);
  }
}
