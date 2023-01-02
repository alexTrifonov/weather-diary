package ru.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.weather.diary.handler.Handler;
import ru.weather.diary.repository.CityRepository;
import ru.weather.diary.repository.WeatherRepository;
import ru.weather.diary.repository.WeatherServerRepository;


@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    Handler handler;


    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    WeatherServerRepository weatherServerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
