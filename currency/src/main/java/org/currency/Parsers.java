package org.currency;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public enum Parsers {
    MONO(new StringBuilder("https://api.monobank.ua/bank/currency")),
    PRIVAT(new StringBuilder("https://api.privatbank.ua/p24api/exchange_rates?json&date="));

    private StringBuilder uri;

    public String getUri() {
        if(this.equals(PRIVAT)) {
            ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Kyiv"));
            if(zonedDateTime.getHour() <= 7)
                zonedDateTime = zonedDateTime.minusDays(1);

            uri.append(zonedDateTime.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
        }

        return uri.toString();
    }
}
