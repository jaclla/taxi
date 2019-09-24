package com.logic.taxi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/hello")
  public String hello() {
    return "hello SpringBoot";
  }

  @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户ID", required = true,
          dataType = "Integer", paramType = "query")
  })
  @GetMapping("/selectById")
  public RetResult<UserInfo> selectById(@RequestParam Integer id) {
    UserInfo userInfo = userInfoService.selectById(id);
    return RetResponse.makeOKRsp(userInfo);
  }

  @ApiOperation(value = "不分页查询用户", notes = "不分页查询用户列表")
  @GetMapping("/selectList")
  public RetResult selectList() {
    List<UserInfo> userInfo = userInfoService.selectList();
    return RetResponse.makeOKRsp(userInfo);
  }

  @ApiOperation(value = "分页查询用户", notes = "分页查询用户列表")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "page", value = "当前页码",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "size", value = "每页显示条数",
          dataType = "Integer", paramType = "query")
  })
  @GetMapping("/selectPage")
  public RetResult selectPage(@RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "0") Integer size) {
    return RetResponse.makeOKRsp(userInfoService.selectPage(new Page<>(page, size)));
  }


}
