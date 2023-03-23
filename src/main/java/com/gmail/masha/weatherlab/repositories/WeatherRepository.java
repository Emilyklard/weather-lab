package com.gmail.masha.weatherlab.repositories;

import com.gmail.masha.weatherlab.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
