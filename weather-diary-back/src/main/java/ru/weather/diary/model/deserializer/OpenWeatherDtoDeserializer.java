package ru.weather.diary.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.weather.diary.model.dto.OpenWeatherDto;
import ru.weather.util.WeatherUtil;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Component
public class OpenWeatherDtoDeserializer extends StdDeserializer<OpenWeatherDto> {

    private WeatherUtil weatherUtil;

    public OpenWeatherDtoDeserializer() {
        this(OpenWeatherDto.class);
        this.weatherUtil = WeatherUtil.instance;
    }

    public OpenWeatherDtoDeserializer(Class<?> vc) {
        super(vc);
    }

    public OpenWeatherDto deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
        OpenWeatherDto openWeatherDto = new OpenWeatherDto();
        JsonNode root = jp.getCodec().readTree(jp);
        if (root.get("main") != null) {
            JsonNode main = root.get("main");
            if (main.get("temp") != null) {
                double temperature = Double.parseDouble(main.get("temp").asText());
                openWeatherDto.setTemperature((int) Math.round(temperature));
            }
            if (main.get("pressure") != null) {
                int pressure = (Integer) main.get("pressure").numberValue();
                openWeatherDto.setPressure(pressure);
            }
            if (main.get("humidity") != null) {
                int humidity = (Integer) main.get("humidity").numberValue();
                openWeatherDto.setHumidity(humidity);
            }
        }
        if (root.get("visibility") != null) {
            int visibility = (Integer) root.get("visibility").numberValue();
            openWeatherDto.setVisibility(visibility);
        }
        if (root.get("wind") != null) {
            JsonNode wind = root.get("wind");
            if (wind.get("speed") != null) {
                double windSpeed = Double.parseDouble(wind.get("speed").asText());
                openWeatherDto.setWindSpeed((int) Math.round(windSpeed));
            }
            if (wind.get("deg") != null) {
                int windBearing = (Integer) wind.get("deg").numberValue();
                openWeatherDto.setWindBearing(windBearing);
                openWeatherDto.setWindDirection(weatherUtil.azimuthDirection(windBearing));
            }
            if (wind.get("gust") != null) {
                double windGust = Double.parseDouble(wind.get("gust").asText());
                openWeatherDto.setWindGust((int) Math.round(windGust));
            }
        }
        if (root.get("clouds") != null) {
            JsonNode clouds = root.get("clouds");
            if (clouds.get("all") != null) {
                int cloudCover = (Integer) clouds.get("all").numberValue();
                openWeatherDto.setCloudCover(cloudCover);
            }
        }

        if (root.get("dt") != null && root.get("timezone") != null) {
            long time = root.get("dt").longValue();
            int timeShift = root.get("timezone").intValue();
            ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(time*1000), ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(timeShift)));
            openWeatherDto.setDateTime(Timestamp.valueOf(zdt.toLocalDateTime()));
        }

        return openWeatherDto;
    }
}
