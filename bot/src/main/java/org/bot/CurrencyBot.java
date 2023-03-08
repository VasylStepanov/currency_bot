package org.bot;

import org.currency.CurrencyRequest;
import org.currency.Parsers;
import org.currency.dto.Currency;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.function.Function;
import static org.bot.Main.getLogger;

public class CurrencyBot extends TelegramLongPollingBot {

    private static final BotData botData = new BotData();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_return = CommandHandler.handle(update);

            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(chat_id);
            if(message_return != null)
                message.setText(message_return);

            try {
                execute(message);
                getLogger().info("message was sent");
            } catch (TelegramApiException e) {
                getLogger().warning(e.getMessage());
            }
        }
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
