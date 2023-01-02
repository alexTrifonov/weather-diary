package ru.weather.diary.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import ru.weather.diary.model.deserializer.DarkSkyDtoDeserializer;

import java.sql.Timestamp;

@Data
@JsonDeserialize(using = DarkSkyDtoDeserializer.class)
public class DarkSkyDto {
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer windSpeed;
    private Integer windGust;
    private Integer windBearing;
    private Integer cloudCover;
    private Integer uvIndex;
    private Integer visibility;
    private Integer ozone;
    private String windDirection;
    private Timestamp dateTime;

}
