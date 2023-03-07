package org.currency;

import org.currency.dto.Currency;
import org.currency.parse_json.JsonParser;

import java.util.List;

public class CurrencyRequest {

    public List<Currency> getCurrencies(String bankName){
        /*
        TODO
         Get JsonParser object
         Get JSON from bank API
         Get currency array from JSON
         Parse received JSON to get list of currencies
         */
        return null;
    }

    private JsonParser getJsonParser(String bankName){
        //TODO Get JsonParser object
        return null;
    }
}
