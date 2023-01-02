package ru.weather.diary.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.weather.diary.model.City;
import ru.weather.diary.model.Weather;
import ru.weather.diary.model.WeatherServer;
import ru.weather.diary.model.dto.DarkSkyDto;
import ru.weather.diary.model.dto.OpenWeatherDto;
import ru.weather.diary.rest.WeatherDataService;

@Service
public class Handler {
    public static final Logger logger = LoggerFactory.getLogger(Handler.class);
    @Autowired
    WeatherDataService dataService;
    @Autowired
    ObjectMapper objectMapper;

    public final static String DARK_SKY_SERVER = "Dark Sky";
    public final static String OPEN_WEATHER_SERVER = "OpenWeather";

    public Weather getWeather(City city, WeatherServer weatherServer) throws JsonProcessingException {
        String weatherDtoStr = dataService.getJsonWeather(city, weatherServer);
        logger.info("weatherJson = {}", weatherDtoStr);
        Weather weather = null;
        switch (weatherServer.getName()) {
            case DARK_SKY_SERVER:
                DarkSkyDto darkSkyDto = objectMapper.readValue(weatherDtoStr, DarkSkyDto.class);
                        logger.info("darkSkyDto = {}", darkSkyDto);
                weather = new Weather.Builder()
                        .withTemperature(darkSkyDto.getTemperature())
                        .withHumidity(darkSkyDto.getHumidity())
                        .withPressure(darkSkyDto.getPressure())
                        .withWindSpeed(darkSkyDto.getWindSpeed())
                        .withWindGust(darkSkyDto.getWindGust())
                        .withWindBearing(darkSkyDto.getWindBearing())
                        .withCloudCover(darkSkyDto.getCloudCover())
                        .withUvIndex(darkSkyDto.getUvIndex())
                        .withOzone(darkSkyDto.getOzone())
                        .withVisibility(darkSkyDto.getVisibility())
                        .withWindDirection(darkSkyDto.getWindDirection())
                        .withDateTime(darkSkyDto.getDateTime())
                        .withCityId(city.getId())
                        .withServerId(weatherServer.getId())
                        .build();
                logger.info("weatherDarkSky = {}", weather);
                break;
            case OPEN_WEATHER_SERVER:
                OpenWeatherDto openWeatherDto = objectMapper.readValue(weatherDtoStr, OpenWeatherDto.class);
                logger.info("openWeatherDto = {}", openWeatherDto);
                weather = new Weather.Builder()
                        .withTemperature(openWeatherDto.getTemperature())
                        .withHumidity(openWeatherDto.getHumidity())
                        .withPressure(openWeatherDto.getPressure())
                        .withWindSpeed(openWeatherDto.getWindSpeed())
                        .withWindGust(openWeatherDto.getWindGust())
                        .withWindBearing(openWeatherDto.getWindBearing())
                        .withCloudCover(openWeatherDto.getCloudCover())
                        .withVisibility(openWeatherDto.getVisibility())
                        .withWindDirection(openWeatherDto.getWindDirection())
                        .withDateTime(openWeatherDto.getDateTime())
                        .withCityId(city.getId())
                        .withServerId(weatherServer.getId())
                        .build();
                logger.info("weatherOpenWeather = {}", weather);
                break;
        }
        return weather;
    }
}
