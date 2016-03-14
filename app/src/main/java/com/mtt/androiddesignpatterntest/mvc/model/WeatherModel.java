package com.mtt.androiddesignpatterntest.mvc.model;

/**
 * Description: 获取天气信息接口
 * Created by Kerry on 16/3/14.
 */
public interface WeatherModel {

    void getWeather(String cityNumber, OnWeatherListener listener);
}
