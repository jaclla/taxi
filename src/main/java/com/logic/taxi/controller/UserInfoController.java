package com.logic.taxi.controller;

import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoControler")
public class UserInfoController {

  @Resource
  private UserInfoService userInfoService;

  @PostMapping("/hello")
  public String hello() {
    return "hello SpringBoot";
  }

  @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户ID", required = true,
          dataType = "Integer", paramType = "query")
  })
  @PostMapping("/selectById")
  public RetResult<UserInfo> selectById(@RequestParam Integer id) {
    UserInfo userInfo = userInfoService.selectById(id);
    return RetResponse.makeOKRsp(userInfo);
  }

  @PostMapping("/testException")
  public RetResult<UserInfo> testException(Integer id) {
    List a = null;
    a.size();
    UserInfo userInfo = userInfoService.selectById(id);
    return RetResponse.makeOKRsp(userInfo);
  }


}
