package ru.weather.diary.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import ru.weather.diary.model.deserializer.OpenWeatherDtoDeserializer;

import java.sql.Timestamp;

@JsonDeserialize(using = OpenWeatherDtoDeserializer.class)
@Data
public class OpenWeatherDto {
    private Integer windSpeed;
    private Integer windBearing;
    private Integer windGust;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer visibility;
    private Integer cloudCover;
    private String windDirection;
    private Timestamp dateTime;
}
