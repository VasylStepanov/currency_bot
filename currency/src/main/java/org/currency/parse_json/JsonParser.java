package org.currency.parse_json;

import org.currency.dto.Currency;
import org.json.JSONArray;

import java.util.List;

public interface JsonParser {
    List<Currency> parse(String jsonData);
}
