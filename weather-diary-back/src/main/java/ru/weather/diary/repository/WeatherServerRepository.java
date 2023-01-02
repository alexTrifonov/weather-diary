package ru.weather.diary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.weather.diary.model.WeatherServer;

@Repository
public interface WeatherServerRepository extends CrudRepository<WeatherServer, Integer> {
}
