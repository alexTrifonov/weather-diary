package ru.weather.diary.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.weather.diary.handler.Handler;
import ru.weather.diary.model.City;
import ru.weather.diary.model.Weather;
import ru.weather.diary.model.WeatherServer;
import ru.weather.diary.repository.CityRepository;
import ru.weather.diary.repository.WeatherRepository;
import ru.weather.diary.repository.WeatherServerRepository;
import ru.weather.diary.service.WeatherRegistration;

@Service
public class WeatherRegistrationImpl implements WeatherRegistration {
    public static final Logger logger = LoggerFactory.getLogger(WeatherRegistrationImpl.class);
    @Autowired
    Handler handler;

    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    CityRepository cityRepository;

    @Autowired
    WeatherServerRepository weatherServerRepository;

    @Scheduled(fixedDelay = 3600000)
    public void registration() {
        Iterable<City> cities = cityRepository.findAll();
        Iterable<WeatherServer> servers = weatherServerRepository.findAll();
        cities.forEach(city -> {
            servers.forEach(weatherServer -> {
                try {
                    Weather weather = handler.getWeather(city, weatherServer);
                    weatherRepository.save(weather);
                } catch (JsonProcessingException e) {
                    logger.error(e.getMessage(), e);
                }
            });
        });
    }
}
