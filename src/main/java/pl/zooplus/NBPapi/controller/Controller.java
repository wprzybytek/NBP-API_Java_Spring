package pl.zooplus.NBPapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.zooplus.NBPapi.provider.ExchangeRates;
import pl.zooplus.NBPapi.provider.GoldPrice;


@RestController
public class Controller {

    @GetMapping("/api/exchange-rates/{currency}")
    public String exchangeRates(@PathVariable String currency) {
        return new ExchangeRates(currency).getRates();
    }

    @GetMapping("/api/gold-price/average")
    public String goldPrice() {
        return new GoldPrice().getPrice();
    }
}
