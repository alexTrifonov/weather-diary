package ru.weather.diary.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Table(name = "weather")
public class Weather {
    @Id
    private Long id;
    private final Integer temperature;
    private final Integer humidity;
    private final Integer pressure;
    private final Integer windSpeed;
    private final Integer windGust;
    private final Integer windBearing;
    private final Integer cloudCover;
    private final Integer uvIndex;
    private final Integer visibility;
    private final Integer ozone;


    private final String windDirection;

    private final Timestamp dateTime;

    private final Integer cityId;

    private final Integer serverId;

    //Spring Data JDBC требует
    @PersistenceCreator
    public Weather(Long id, Integer temperature, Integer humidity, Integer pressure, Integer windSpeed, Integer windGust, Integer windBearing, Integer cloudCover, Integer uvIndex, Integer visibility, Integer ozone, String windDirection, Timestamp dateTime, Integer cityId, Integer serverId) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.ozone = ozone;
        this.windDirection = windDirection;
        this.dateTime = dateTime;
        this.cityId = cityId;
        this.serverId = serverId;
    }

    private Weather(Builder builder) {
        this.temperature = builder.temperature;
        this.humidity = builder.humidity;
        this.pressure = builder.pressure;
        this.windSpeed = builder.windSpeed;
        this.windGust = builder.windGust;
        this.windBearing = builder.windBearing;
        this.cloudCover = builder.cloudCover;
        this.uvIndex = builder.uvIndex;
        this.visibility = builder.visibility;
        this.ozone = builder.ozone;
        this.windDirection = builder.windDirection;
        this.dateTime = builder.dateTime;
        this.cityId = builder.cityId;
        this.serverId = builder.serverId;
    }

    public static class Builder {
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
        private Integer cityId;
        private Integer serverId;
        public Builder() {};

        public Builder withTemperature(Integer temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withHumidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withPressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withWindSpeed(Integer windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder withWindGust(Integer windGust) {
            this.windGust = windGust;
            return this;
        }

        public Builder withWindBearing(Integer windBearing) {
            this.windBearing = windBearing;
            return this;
        }

        public Builder withCloudCover(Integer cloudCover) {
            this.cloudCover = cloudCover;
            return this;
        }
        public Builder withUvIndex(Integer uvIndex) {
            this.uvIndex = uvIndex;
            return this;
        }
        public Builder withVisibility(Integer visibility) {
            this.visibility = visibility;
            return this;
        }
        public Builder withOzone(Integer ozone) {
            this.ozone = ozone;
            return this;
        }
        public Builder withWindDirection(String windDirection) {
            this.windDirection = windDirection;
            return this;
        }
        public Builder withDateTime(Timestamp dateTime) {
            this.dateTime = dateTime;
            return this;
        }
        public Builder withCityId(Integer cityId) {
            this.cityId = cityId;
            return this;
        }
        public Builder withServerId(Integer serverId) {
            this.serverId = serverId;
            return this;
        }

        public Weather build() {
            return new Weather(this);
        }
    }
}
