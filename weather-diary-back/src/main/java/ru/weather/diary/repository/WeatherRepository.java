package ru.weather.diary.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.weather.diary.model.Weather;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    @Query("select * from  weather where city_id =:id order by date_time")
    List<Weather> findWeatherByCity(@Param("id") int id);
    @Query("select * from  weather where server_id =:id order by date_time")
    List<Weather> findWeatherByServer(@Param("id") int id);

    @Query("select * from  weather where server_id = :serverId and city_id = :cityId order by date_time")
    List<Weather> findWeatherByServerAndCity(@Param("serverId") int serverId, @Param("cityId") int cityId);

    @Query("select * from  weather where date_time::date =:localDate order by date_time")
    List<Weather> findWeatherByDate(@Param("localDate") LocalDate localDate);

    //верхняя граница диапазона дат для timestamp не включается в выборку даже при <=
    @Query("select * from  weather where date_time >= :startDate and date_time < :endDate order by date_time")
    List<Weather> findWeatherFromToDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("select * from  weather where city_id = :id and date_time::date =:localDate order by date_time")
    List<Weather> findWeatherByCityAndDate(@Param("id") int id, @Param("localDate") LocalDate localDate);

    @Query("select * from  weather where city_id = :id and date_time >= :startDate and date_time < :endDate order by date_time")
    List<Weather> findWeatherByCityAndFromToDate(@Param("id") int id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("select * from  weather where server_id = :serverId and city_id = :cityId and date_time::date =:localDate order by date_time")
    List<Weather> findWeatherByServerAndCityAndDate(@Param("serverId") int serverId,
                                                      @Param("cityId") int cityId, @Param("localDate") LocalDate localDate);

    @Query("select * from  weather where server_id = :serverId and city_id = :cityId and date_time >= :startDate and date_time < :endDate order by date_time")
    List<Weather> findWeatherByServerAndCityAndFromToDate(@Param("serverId") int serverId,
                                                      @Param("cityId") int cityId,
                                                          @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
