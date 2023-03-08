package org.bot;

import org.currency.CurrencyRequest;
import org.currency.Parsers;
import org.currency.dto.Currency;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.function.Function;

import static org.bot.Main.getLogger;

public class CommandHandler {

    public static String handle(Update update) {
        String message_text = update.getMessage().getText();

        if(message_text.startsWith("/")) {
            String message_return;

            CurrencyRequest request = new CurrencyRequest();

            getLogger().info("Get command: " + message_text);

            Function<List<Currency>, String> currencyListToString = (currencies) -> {
                StringBuilder currencyString = new StringBuilder();
                for (Currency currency : currencies)
                    currencyString.append("\n===========================\n").append(currency);
                if(currencyString.length() != 0)
                    currencyString.append("\n===========================\n");
                return currencyString.toString();
            };

            switch (message_text) {
                case "/start" -> {
                    message_return = String.format("@%s hello, and welcome to Currency Bot!",
                            update.getMessage().getFrom().getUserName());
                }
                case "/privat" -> {
                    List<Currency> currencies = request.getCurrencies(Parsers.PRIVAT);
                    message_return = currencyListToString.apply(currencies);
                }
                case "/mono" -> {
                    List<Currency> currencies = request.getCurrencies(Parsers.MONO);
                    message_return = currencyListToString.apply(currencies);
                }
                default -> {
                    message_return = "Sorry, there is no such command";
                }
            }

            return message_return;
        } else {
            return null;
        }
    }
}
