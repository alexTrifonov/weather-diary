package ru.weather.util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ru.weather.diary.enums.WindDirection.*;

public class WeatherUtilTest {
    private WeatherUtil weatherUtil;

    @BeforeClass
    public void setUp() {
        this.weatherUtil = new WeatherUtil();
    }

    @Test
    public void azimuthDirectionNorthTest() {
        String result = weatherUtil.azimuthDirection(338);
        Assert.assertEquals(result, NORTH.toString());
    }

    @Test
    public void aziazimuthDirectionNorthEastTest() {
        String result = weatherUtil.azimuthDirection(23);
        Assert.assertEquals(result, NORTH_EAST.toString());
    }

    @Test
    public void aziazimuthDirectionEastTest() {
        String result = weatherUtil.azimuthDirection(68);
        Assert.assertEquals(result, EAST.toString());
    }

    @Test
    public void aziazimuthDirectionSouthEastTest() {
        String result = weatherUtil.azimuthDirection(113);
        Assert.assertEquals(result, SOUTH_EAST.toString());
    }

    @Test
    public void aziazimuthDirectionSouthTest() {
        String result = weatherUtil.azimuthDirection(158);
        Assert.assertEquals(result, SOUTH.toString());
    }

    @Test
    public void aziazimuthDirectionSouthWestTest() {
        String result = weatherUtil.azimuthDirection(203);
        Assert.assertEquals(result, SOUTH_WEST.toString());
    }

    @Test
    public void aziazimuthDirectionWestTest() {
        String result = weatherUtil.azimuthDirection(248);
        Assert.assertEquals(result, WEST.toString());
    }

    @Test
    public void aziazimuthDirectionNorthWestTest() {
        String result = weatherUtil.azimuthDirection(293);
        Assert.assertEquals(result, NORTH_WEST.toString());
    }
}
