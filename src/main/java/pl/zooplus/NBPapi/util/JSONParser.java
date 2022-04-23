package pl.zooplus.NBPapi.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
    public static String parseCurrency(String responseBody) {
        JSONArray rates = new JSONObject(responseBody).getJSONArray("rates");
        JSONArray parsedRates = new JSONArray();
        for (int i = 0; i < rates.length(); i++) {
            JSONObject rate = (JSONObject) rates.get(i);
            JSONObject parsedRate = new JSONObject();
            parsedRate.put("Date", rate.get("effectiveDate"));
            parsedRate.put("Price", rate.get("mid"));
            parsedRates.put(parsedRate);
        }
        return parsedRates.toString(1);
    }

    public static String parseGold(String responseBody) {
        JSONArray prices = new JSONArray(responseBody);
        double sum = 0;
        for (int i = 0; i < prices.length(); i++) {
            sum += ((JSONObject) prices.get(i)).getDouble("cena");
        }
        return String.format("%.2f", sum / prices.length());
    }
}
