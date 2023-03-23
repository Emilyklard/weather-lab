package com.gmail.masha.weatherlab.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class WeatherDto implements Serializable {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("LocalTime")
    private LocalDateTime localTime;
    @JsonProperty("temp_c")
    private double temp_c;
    @JsonProperty("wind_mph")
    private Integer wind_mph;
    @JsonProperty("pressure_mb")
    private Integer pressure_mb;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("condition")
    private String condition;

    public WeatherDto(String name, LocalDateTime localTime, double temp_c, Integer wind_mph, Integer pressure_mb, Integer humidity, String condition) {
        this.name = name;
        this.localTime = localTime;
        this.temp_c = temp_c;
        this.wind_mph = wind_mph;
        this.pressure_mb = pressure_mb;
        this.humidity = humidity;
        this.condition = condition;
    }

    public WeatherDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public Integer getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(Integer wind_mph) {
        this.wind_mph = wind_mph;
    }

    public Integer getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Integer pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "name='" + name + '\'' +
                ", localTime=" + localTime +
                ", temp_c=" + temp_c +
                ", wind_mph=" + wind_mph +
                ", pressure_mb=" + pressure_mb +
                ", humidity=" + humidity +
                ", condition='" + condition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDto that = (WeatherDto) o;
        return Double.compare(that.temp_c, temp_c) == 0 && Objects.equals(name, that.name) && Objects.equals(localTime, that.localTime) && Objects.equals(wind_mph, that.wind_mph) && Objects.equals(pressure_mb, that.pressure_mb) && Objects.equals(humidity, that.humidity) && Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, localTime, temp_c, wind_mph, pressure_mb, humidity, condition);
    }
  /*  {
        "location": {
                "name": "Minsk",
                "region": "Minsk",
                "country": "Belarus",
                "lat": 53.9,
                "lon": 27.57,
                "tz_id": "Europe/Minsk",
                "localtime_epoch": 1679494665,
                "localtime": "2023-03-22 17:17"
    },
        "current": {
        "last_updated_epoch": 1679494500,
                "last_updated": "2023-03-22 17:15",
                "temp_c": 10,
                "temp_f": 50,
                "is_day": 1,
                "condition": {
            "text": "Partly cloudy",
                    "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png",
                    "code": 1003
        },
        "wind_mph": 6.9,
                "wind_kph": 11.2,
                "wind_degree": 210,
                "wind_dir": "SSW",
                "pressure_mb": 1013,
                "pressure_in": 29.91,
                "precip_mm": 0,
                "precip_in": 0,
                "humidity": 54,
                "cloud": 75,
                "feelslike_c": 7.7,
                "feelslike_f": 45.9,
                "vis_km": 10,
                "vis_miles": 6,
                "uv": 4,
                "gust_mph": 13.6,
                "gust_kph": 22
  */  }


