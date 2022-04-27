package pl.zooplus.NBPapi.provider;

import pl.zooplus.NBPapi.util.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoldPrice {
    private final String requestBody;

    public GoldPrice() {
        this.requestBody = "https://api.nbp.pl/api/cenyzlota/last/14/?format=json";
    }

    public String getPrice() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestBody)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JSONParser::parseGold)
                .join();
    }
}
