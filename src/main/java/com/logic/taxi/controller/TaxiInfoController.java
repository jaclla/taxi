package com.logic.taxi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.service.TaxiInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("taxiInfo")
@Api(tags = {"拼车操作接口"}, description = "taxiInfoControler")
public class TaxiInfoController {

  @Resource
  private TaxiInfoService taxiInfoService;

  @ApiOperation(value = "添加拼车信息", notes = "添加拼车信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "type", value = "类型",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "server_type", value = "服务类型",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "region", value = "服务区域",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "price", value = "价格",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "subscriptionDate", value = "订阅时间",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "secrecyLabel", value = "保密标签",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "description", value = "描述",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "email", value = "邮箱",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "wechat", value = "微信号",
          dataType = "String", paramType = "query")
  })
  @PostMapping("/insert")
  public RetResult insert(TaxiInfo taxiInfo) {
    return taxiInfoService.insert(taxiInfo);
  }

  @ApiOperation(value = "分页获取拼车信息", notes = "分页获取拼车信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "type", value = "类型",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "page", value = "当前页码",
          dataType = "Integer", paramType = "query"),
      @ApiImplicitParam(name = "size", value = "每页显示条数",
          dataType = "Integer", paramType = "query")
  })
  @PostMapping("/selectPage")
  public RetResult selectPage(Boolean type, @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "0") Integer size) {
    return taxiInfoService.selectPage(type, new Page<>(page, size));
  }
  @ApiOperation(value = "不分页获取拼车信息", notes = "不分页获取拼车信息")
  @PostMapping("/selectList")
  public RetResult selectList(Boolean type) {
    return taxiInfoService.selectList(type);
  }
}
