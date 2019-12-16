package com.project.travel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ProxyService {
  @Value("${api.exchangerates.endpoint}")
  private String exchangeRatesUrl;

  @Value("${api.eventful.endpoint}")
  private String eventsUrl;

  @Value("${api.eventful.app_key}")
  private String eventsKey;

  private RestTemplate restTemplate = new RestTemplate();

  public String getExchangeRates() {
    return restTemplate.getForObject(exchangeRatesUrl, String.class);
  }

  public String getEvents(String location) {
    String eventsEndpoint = eventsUrl + "/search?app_key=" + eventsKey + "&location=" + location;
    return restTemplate.getForObject(eventsEndpoint, String.class);
  }
}
