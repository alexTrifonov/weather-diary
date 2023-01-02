package ru.weather.diary.rest;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherDataServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImplTest.class);
    @Test
    @DisplayName("Данные от OpenWeather")
    @Description("Тест получения погодных данных в json-формате с сервера OpenWeather")
    @Step("Шаг 1")
    public void getJsonWeatherTest() {

    }
}
