package com.gmail.masha.weatherlab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "location")
    @NotEmpty(message = "The location should not be empty!")
    @Size(min = 3, max = 30, message = "The location should be between 3 and 30 characters!")
    private String name;

    @Column(name = "date_time")
    @NotNull
    private LocalDateTime localTime;

    @Column(name = "temperature")
    @NotNull
    private double temp_c;

    @Column(name = "wind_speed")
    @NotNull
    private Integer wind_mph;

    @Column(name = "atmospheric_pressure")
    @NotNull
    private Integer pressure_mb;

    @Column(name = "air_humidity")
    @NotNull
    private Integer humidity;

    @Column(name = "weather")
    @NotEmpty(message = "Weather should not be empty!")
    private String condition;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Weather{" +
                "name='" + name + '\'' +
                ", localTime=" + localTime +
                ", temp_c=" + temp_c +
                ", wind_mph=" + wind_mph +
                ", pressure_mb=" + pressure_mb +
                ", humidity=" + humidity +
                ", condition='" + condition + '\'' +
                '}';
    }
}
