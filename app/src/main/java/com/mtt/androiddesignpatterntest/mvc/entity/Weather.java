package com.mtt.androiddesignpatterntest.mvc.entity;

import java.io.Serializable;

/**
 * Description: 天气实体类
 * Created by Kerry on 16/3/14.
 */
public class Weather implements Serializable {

    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}
