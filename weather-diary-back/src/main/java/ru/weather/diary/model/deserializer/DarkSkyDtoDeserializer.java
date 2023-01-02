package ru.weather.diary.model.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.weather.diary.model.dto.DarkSkyDto;
import ru.weather.util.WeatherUtil;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class DarkSkyDtoDeserializer extends StdDeserializer {

    private WeatherUtil weatherUtil;

    public DarkSkyDtoDeserializer() {
        this(DarkSkyDto.class);
        this.weatherUtil = WeatherUtil.instance;
    }

    public DarkSkyDtoDeserializer(Class<?> vc) {
        super(vc);
    }


    @Override
    public DarkSkyDto deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JacksonException {
        DarkSkyDto darkSkyDto = new DarkSkyDto();
        JsonNode root = jp.getCodec().readTree(jp);
        String timeZone = null;
        if (root.get("timezone") != null) {
            timeZone = root.get("timezone").asText();
        }
        if (root.get("currently") != null) {
            JsonNode currently = root.get("currently");
            if (timeZone != null && currently.get("time") != null) {
                long time = currently.get("time").longValue();
                ZonedDateTime zdt = Instant.ofEpochMilli(time*1000).atZone(ZoneId.of(timeZone));
                darkSkyDto.setDateTime(Timestamp.valueOf(zdt.toLocalDateTime()));
            }
            if (currently.get("temperature") != null) {
                double temperature = Double.parseDouble(currently.get("temperature").asText());
                darkSkyDto.setTemperature((int) Math.round(temperature));
            }
            if (currently.get("humidity") != null) {
                int humidity = (int) ((Double) currently.get("humidity").numberValue() * 100);
                darkSkyDto.setHumidity(humidity);
            }
            if (currently.get("pressure") != null) {
                //давление может быть как целым числом, так и вещественным
                double pressure = Double.parseDouble(currently.get("pressure").asText());
                darkSkyDto.setPressure((int) Math.round(pressure));
            }
            if (currently.get("windSpeed") != null) {
                double windSpeed = Double.parseDouble(currently.get("windSpeed").asText());
                darkSkyDto.setWindSpeed((int) Math.round(windSpeed));
            }
            if (currently.get("windGust") != null) {
                double windGust = Double.parseDouble(currently.get("windGust").asText());
                darkSkyDto.setWindGust((int) Math.round(windGust));
            }
            if (currently.get("windBearing") != null) {
                int windBearing = (int) currently.get("windBearing").numberValue();
                darkSkyDto.setWindBearing(windBearing);
                darkSkyDto.setWindDirection(weatherUtil.azimuthDirection(windBearing));
            }
            if (currently.get("cloudCover") != null) {
                double cloudCoverDouble = Double.parseDouble(currently.get("cloudCover").asText());
                int cloudCover = (int) (cloudCoverDouble*100);
                darkSkyDto.setCloudCover(cloudCover);
            }
            if (currently.get("uvIndex") != null) {
                int uvIndex = (int) currently.get("uvIndex").numberValue();
                darkSkyDto.setUvIndex(uvIndex);
            }
            if (currently.get("visibility") != null) {
                double visibility = Double.parseDouble(currently.get("visibility").asText());
                darkSkyDto.setVisibility((int) Math.round(visibility));
            }
            if (currently.get("ozone") != null) {
                //количество озона может быть как целым числом, так и вещественным
                double ozone = Double.parseDouble(currently.get("ozone").asText());
                darkSkyDto.setOzone((int) Math.round(ozone));
            }
        }

        return darkSkyDto;
    }
}
