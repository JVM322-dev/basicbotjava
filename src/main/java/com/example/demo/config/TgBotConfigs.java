package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@Data
public class TgBotConfigs {
    @Value("${bot.name}")
    String botname;
    @Value("${bot.key}")
    String botkey;
}
