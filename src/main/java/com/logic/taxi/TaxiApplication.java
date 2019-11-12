package com.logic.taxi;


import com.logic.taxi.core.configurer.MyBot;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@EnableAsync
public class TaxiApplication {
  private static String BOT_NAME = "qupinche_bot";
  private static String BOT_TOKEN = "892496141:AAGjGhDpDD4xYnJYgeDttJgUfEsLEBIECdU";/* your bot's token here */;
//
//  private static String PROXY_HOST = "34.92.31.62" /* proxy host */;
//  private static Integer PROXY_PORT = 8088 /* proxy port */;
//  private static String PROXY_USER = "tgBot" /* proxy user */;
//  private static String PROXY_PASSWORD = "kimmaro" /* proxy password */;


  public static void main(String[] args) {
    try {

      // Create the Authenticator that will return auth's parameters for proxy authentication
//      Authenticator.setDefault(new Authenticator() {
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication() {
//          return new PasswordAuthentication(PROXY_USER, PROXY_PASSWORD.toCharArray());
//        }
//      });

      ApiContextInitializer.init();

      // Create the TelegramBotsApi object to register your bots
      TelegramBotsApi botsApi = new TelegramBotsApi();

      // Set up Http proxy
      DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//
//      botOptions.setProxyHost("127.0.0.1");
//      botOptions.setProxyPort(10808);
      // Select proxy type: [HTTP|SOCKS4|SOCKS5] (default: NO_PROXY)
//      botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
      // Register your newly created AbilityBot
      MyBot bot = new MyBot(BOT_TOKEN, BOT_NAME,botOptions);

      botsApi.registerBot(bot);

    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
    SpringApplication.run(TaxiApplication.class, args);
  }

}
