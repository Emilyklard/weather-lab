package com.gmail.masha.weatherlab.services;

import com.gmail.masha.weatherlab.models.Weather;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class WeatherClient {

  private final RestTemplate restTemplate;
  public WeatherClient(RestTemplateBuilder restTemplateBuilder){
    this.restTemplate = restTemplateBuilder.build();
  }

  public Weather getTotals() {
    Weather weather = null;
    String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("X-RapidAPI-Key", "8eb430aeb3mshb9a80249d052e79p1ea706jsn5db0bf8e8f25");
    headers.add("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<Weather[]> weather1 = restTemplate.exchange(url, HttpMethod.GET, request, Weather[].class, headers);
    //Weather weather = restTemplate.getForObject(url, Weather.class, request);
    //Weather weather = restTemplate.exchange(url, HttpMethod.GET, request, Weather.class).getBody();
weather = weather1.getBody()[0];
    return weather;
  }
 /*  public WeatherClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }



 public Weather goToWeatherApi() {
    Weather weather = restTemplate
        .getForEntity("https://gimeteo.by/", Weather.class).getBody();
    return weather;
  }

*/

}
