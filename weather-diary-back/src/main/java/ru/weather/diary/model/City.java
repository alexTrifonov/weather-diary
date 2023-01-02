package ru.weather.diary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table(name = "city")
public class City {
    @Id
    private Integer id;
    private final String name;
    private final String longitude;
    private final String latitude;

    public static City of(String name, String longitude, String latitude) {
        return new City(null, name, longitude, latitude);
    }

}
