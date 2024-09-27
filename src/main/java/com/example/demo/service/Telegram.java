package com.example.demo.service;

import com.example.demo.config.TgBotConfigs;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Telegram extends TelegramLongPollingBot {

    final TgBotConfigs config;
    public Telegram(TgBotConfigs config){
        this.config = config;
    }
    @Override
    public String getBotUsername() {
        return config.getBotname();
    }

    @Override
    public String getBotToken() {
        return config.getBotkey();
    }

    @Override
    public void onUpdateReceived(Update update) {
          if(update.hasMessage()&&update.getMessage().hasText()){
              String Message = update.getMessage().getText();
              long chatid = update.getMessage().getChatId();
              String name  = update.getMessage().getChat().getFirstName();
              switch(Message) {
                  case "/start":
                          SendMessage(chatid, name);
                          break;

                  default:

                          SendMessage(chatid, "Извини не понял команду");

              }
          }

    }
    private void SendMessage(long chatid,String name) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatid));
        message.setText(RecivedMessage(name));
        try {
            executeAsync(message);
        }catch(TelegramApiException e){

        }

    }
    private String RecivedMessage(String name){
        String answer = "Привет ,"+name+"рад с тобой познакомиться";
        return answer;
    }
}
