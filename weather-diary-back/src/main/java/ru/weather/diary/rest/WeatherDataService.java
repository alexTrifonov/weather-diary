package ru.weather.diary.rest;

import ru.weather.diary.model.City;
import ru.weather.diary.model.WeatherServer;

public interface WeatherDataService {
    String getJsonWeather(City city, WeatherServer weatherServer);
}
