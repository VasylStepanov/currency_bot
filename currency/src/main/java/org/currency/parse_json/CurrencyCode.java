package org.currency.parse_json;

import java.util.Map;

public class CurrencyCode {
    private static final Map<Integer, String> currencyCode = Map.of(
            980, "UAH", 840, "USD", 978, "EUR",
            975, "PLN", 398, "KZT", 826, "GBP"
    );

    public static String getCurrencyCode(Integer key){
        return currencyCode.get(key);
    }

    public static Map<Integer, String> getCurrencyCodes(){
        return currencyCode;
    }
}
