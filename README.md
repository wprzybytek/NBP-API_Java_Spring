# Java Spring project with NBP Web Api
## Description
Service exposing following endpoints:
 - GET /api/exchange-rates/{currencyCode} - returns currency exchange rate PLN to {currencyCode} for the last 5 business days
 - GET /api/gold-price/average - returns average gold price for the last 14 business days
## Used technologies
 - Java 17 + Gradle 4.7.1
 - Spring Boot 2.6.7 with Spring Web
 - org.JSON
