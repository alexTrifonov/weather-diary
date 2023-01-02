package ru.weather.diary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table(name = "weather_server")
public class WeatherServer {
    @Id
    private Integer id;
    private final String url;
    private final String name;
    private final String key;
    private String currentWeatherUrl;

    public static WeatherServer of(String url, String name, String key, String currentWeatherUrl) {
        return new WeatherServer(null, url, name, key, currentWeatherUrl);
    }
}
