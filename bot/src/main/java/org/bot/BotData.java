package org.bot;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class BotData {

    private final String botUsername;
    private final String botToken;

    public BotData() {
        Properties properties = new Properties();

        try(InputStream is = this.getClass().getResourceAsStream("/application.properties")) {
            properties.load(is);
            botUsername = properties.getProperty("bot.username");
            botToken = properties.getProperty("bot.token");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
