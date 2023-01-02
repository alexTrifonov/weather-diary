package ru.weather.diary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.weather.diary.model.City;


@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
