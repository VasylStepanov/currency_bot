package org.currency.parse_json;

import org.currency.dto.Currency;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import static org.currency.parse_json.CurrencyCode.getCurrencyCode;

public class MonoJsonParser implements JsonParser {

    @Override
    public List<Currency> parse(String jsonData) {
        JSONArray array = new JSONArray(jsonData);
        List<Currency> currencies = new LinkedList<>();

        for (Object obj : array){
            JSONObject object = new JSONObject(obj.toString());

            String codeA, codeB;
            double buy, sell;
            if((codeA = getCurrencyCode(object.getInt("currencyCodeA"))) == null
                || (codeB = getCurrencyCode(object.getInt("currencyCodeB"))) == null
                || (buy = object.getDouble("rateBuy")) == 0
                || (sell = object.getDouble("rateSell")) == 0)
                continue;

            currencies.add(new Currency(codeB, codeA, buy, sell));
        }

        return currencies;
    }
}
