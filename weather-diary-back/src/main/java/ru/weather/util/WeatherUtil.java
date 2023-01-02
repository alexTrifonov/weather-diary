package ru.weather.util;

import org.springframework.stereotype.Service;
import ru.weather.diary.enums.WindDirection;

@Service
public class WeatherUtil {
    public static WeatherUtil instance;
    public WeatherUtil() {
        WeatherUtil.instance = this;
    }

    public String azimuthDirection(int degree) {
        String windDirectionRes = null;
        if (WindDirection.NORTH.getStartDegree() <= degree || degree <= WindDirection.NORTH.getEndDegree())
            windDirectionRes = WindDirection.NORTH.toString();
        else if (WindDirection.NORTH_EAST.getStartDegree() <= degree && degree <= WindDirection.NORTH_EAST.getEndDegree())
            windDirectionRes = WindDirection.NORTH_EAST.toString();
        else if (WindDirection.EAST.getStartDegree() <= degree && degree <= WindDirection.EAST.getEndDegree())
            windDirectionRes = WindDirection.EAST.toString();
        else if (WindDirection.SOUTH_EAST.getStartDegree() <= degree && degree <= WindDirection.SOUTH_EAST.getEndDegree())
            windDirectionRes = WindDirection.SOUTH_EAST.toString();
        else if (WindDirection.SOUTH.getStartDegree() <= degree && degree <= WindDirection.SOUTH.getEndDegree())
            windDirectionRes = WindDirection.SOUTH.toString();
        else if (WindDirection.SOUTH_WEST.getStartDegree() <= degree && degree <= WindDirection.SOUTH_WEST.getEndDegree())
            windDirectionRes = WindDirection.SOUTH_WEST.toString();
        else if (WindDirection.WEST.getStartDegree() <= degree && degree <= WindDirection.WEST.getEndDegree())
            windDirectionRes = WindDirection.WEST.toString();
        else if (WindDirection.NORTH_WEST.getStartDegree() <= degree && degree <= WindDirection.NORTH_WEST.getEndDegree())
            windDirectionRes = WindDirection.NORTH_WEST.toString();
        return windDirectionRes;
    }

    public int roundValue(String value) {
        return (int) Math.round(Double.parseDouble(value));
    }
}
