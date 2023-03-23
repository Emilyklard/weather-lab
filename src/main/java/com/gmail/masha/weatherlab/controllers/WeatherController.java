package com.gmail.masha.weatherlab.controllers;

import com.gmail.masha.weatherlab.models.Weather;
import com.gmail.masha.weatherlab.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public List<Weather> getWeathers() {
        return weatherService.findAll(); // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    public Weather getWeather(@PathVariable("id") int id) {
        return weatherService.findOne(id); // Jackson конвертирует в JSON
    }
}
