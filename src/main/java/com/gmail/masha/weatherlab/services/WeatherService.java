package com.gmail.masha.weatherlab.services;

import com.gmail.masha.weatherlab.models.Weather;
import com.gmail.masha.weatherlab.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class WeatherService {
    private final WeatherRepository weatherRepository;
@Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    public Weather findOne(int id) {
        Optional<Weather> foundWeather = weatherRepository.findById(id);
        return foundWeather.orElse(null);
    }
}
