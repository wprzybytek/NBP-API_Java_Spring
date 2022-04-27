package pl.zooplus.NBPapi.provider;

import org.json.JSONException;
import pl.zooplus.NBPapi.util.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRates {
    private final String requestBody;

    public ExchangeRates(String currency) {
        this.requestBody = String
                .format("https://api.nbp.pl/api/exchangerates/rates/a/%s/last/5?format=json", currency);
    }

    public String getRates() throws JSONException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestBody)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JSONParser::parseCurrency)
                .join();
    }

}
