package org.currency.parse_json;

import org.currency.dto.Currency;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import static org.currency.parse_json.CurrencyCode.getCurrencyCodes;

public class PrivatJsonParser implements JsonParser {

    @Override
    public List<Currency> parse(String jsonData) {

        JSONObject jsonObject = new JSONObject(jsonData);
        if (jsonObject.has("status"))
            throw new RuntimeException(jsonObject.getString("message"));


        JSONArray array = new JSONArray(new JSONObject(jsonData).getJSONArray("exchangeRate"));

        List<Currency> currencies = new LinkedList<>();

        for(Object obj : array){
            JSONObject object = new JSONObject(obj.toString());

            String currency = object.getString("currency");
            if(!getCurrencyCodes().containsValue(currency))
                continue;

            currencies.add(new Currency(
                    object.getString("baseCurrency"),
                    currency,
                    object.getDouble("purchaseRateNB"),
                    object.getDouble("saleRateNB")
            ));
        }
        return currencies;
    }
}
