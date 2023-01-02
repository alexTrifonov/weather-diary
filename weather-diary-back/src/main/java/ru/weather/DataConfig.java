package ru.weather;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeConvertEvent;
import ru.weather.diary.model.City;
import ru.weather.diary.model.WeatherServer;

import javax.sql.DataSource;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableJdbcRepositories(basePackages = "ru.weather.diary.repository")
public class DataConfig {
    final AtomicInteger idCity = new AtomicInteger(0);
    final AtomicInteger idServer = new AtomicInteger(0);

    @Bean
    public ApplicationListener<BeforeConvertEvent> idSetting() {
        return event -> {
            if (event.getEntity() instanceof City && event.getEntity() != null) {
                setCityIds((City) event.getEntity());
            } else if (event.getEntity() instanceof WeatherServer && event.getEntity() != null) {
                setServerIds((WeatherServer) event.getEntity());
            }

        };
    }

    private void setCityIds(City city) {
        if (city.getId() == null) {
            city.setId(idCity.incrementAndGet());
        }
    }

    private void setServerIds(WeatherServer server) {
        if (server.getId() == null) {
            server.setId(idServer.incrementAndGet());
        }
    }


}
