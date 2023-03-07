package org.currency;

import org.currency.dto.Currency;
import org.currency.parse_json.JsonParser;
import org.currency.parse_json.MonoJsonParser;
import org.currency.parse_json.PrivatJsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CurrencyRequest {

    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();

    public List<Currency> getCurrencies(Parsers bank) {
        JsonParser jsonParser = getJsonParser(bank);
        String jsonData = getJsonFromBankApi(bank);
        return jsonParser.parse(jsonData);
    }

    private JsonParser getJsonParser(Parsers bank){
        switch (bank){
            case MONO -> { return new MonoJsonParser(); }
            case PRIVAT -> { return new PrivatJsonParser(); }
            default -> throw new RuntimeException("There is no such a parser!");
        }
    }

    private String getJsonFromBankApi(Parsers bank){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(bank.getUri()))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().toString();
        } catch ( IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
