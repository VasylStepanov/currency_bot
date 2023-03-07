package org.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurrencyBot extends TelegramLongPollingBot {

    private static final BotData botData = new BotData();

    @Override
    public void onUpdateReceived(Update update) {
        //TODO
    }

    @Override
    public String getBotUsername() {
        return botData.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botData.getBotToken();
    }
}
