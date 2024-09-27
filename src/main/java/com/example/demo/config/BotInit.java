package com.example.demo.config;

import com.example.demo.service.Telegram;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@Slf4j
@Component

public class BotInit {
    @Autowired
    Telegram bot;
    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        try {
            api.registerBot(bot);
        }catch(TelegramApiException e){
            log.error("Error class botinit : ",e.getMessage());
        }
    }
}
