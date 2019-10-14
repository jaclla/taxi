package com.logic.taxi.controller;

import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.service.TelegramService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bot")
@Api(tags = {"tg机器人"}, description = "tg机器人控制器")
public class TelegramBotConrtroller {

  @Resource
  private TelegramService telegramService;

  @ApiOperation(value = "发送信息", notes = "发送信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "message", value = "信息",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "sender", value = "发送方",
          dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "recipient", value = "接收方",
          dataType = "String", paramType = "query")
  })
  @PostMapping("/sendMsg")
  public RetResult sendMsg(String message, String sender, Long taxiID) {
    return     telegramService.sendMsg(message, sender, taxiID);
  }


}
