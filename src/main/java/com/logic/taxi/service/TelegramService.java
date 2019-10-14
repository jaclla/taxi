package com.logic.taxi.service;


import com.logic.taxi.core.ret.RetResult;

public interface TelegramService  {

  RetResult sendMsg(String message, String sender, Long taxiID);
}
