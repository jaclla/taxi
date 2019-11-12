package com.logic.taxi.core.configurer;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class MyBot extends AbilityBot {

  public MyBot(String botToken, String botUsername,DefaultBotOptions botOptions) {
    super(botToken, botUsername,botOptions);
  }

  @Override
  public int creatorId() {
    return 696478020;
  }

  public Ability saysHelloWorldToFriend() {
    return Ability.builder()
        .name("sayhi")
        .info("Says hi")
        .privacy(PUBLIC)
        .locality(ALL)
        .input(1)
        .action(ctx -> silent.send("Hi " + ctx.firstArg(), ctx.chatId()))
        .build();
  }


}
