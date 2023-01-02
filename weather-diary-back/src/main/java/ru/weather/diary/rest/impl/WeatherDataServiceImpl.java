package ru.weather.diary.rest.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.weather.diary.model.City;
import ru.weather.diary.model.WeatherServer;
import ru.weather.diary.rest.WeatherDataService;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    RestTemplate restTemplate;

    public String getJsonWeather(City city, WeatherServer weatherServer) {
        String url = weatherServer.getCurrentWeatherUrl()
                .replace("[key]", weatherServer.getKey())
                .replace("[latitude]", city.getLatitude())
                .replace("[longitude]", city.getLongitude());
        return restTemplate.getForObject(url, String.class);
    }





}
