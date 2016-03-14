package com.mtt.androiddesignpatterntest.mvc.model;

import android.util.Log;

import com.mtt.androiddesignpatterntest.mvc.entity.Weather;
import com.mtt.androiddesignpatterntest.mvc.retrofit.FirstApiClient;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Description: 获取天气信息的实现
 * Created by Kerry on 16/3/14.
 */
public class WeatherModelImpl implements WeatherModel {

    private static final String TAG = WeatherModelImpl.class.getSimpleName();

    @Override
    public void getWeather(String cityNumber, final OnWeatherListener listener) {
        FirstApiClient.getInstance().getWeather(cityNumber, new Callback<Weather>() {
            @Override
            public void onResponse(Response<Weather> response, Retrofit retrofit) {
                Log.d(TAG, "----------------onResponse------------------");
                Weather weather = response.body();
                if(weather == null){
                    listener.onError();
                }else{
                    listener.onSuccess(weather);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "----------------onFailure------------------"+t.getMessage());
                listener.onError();
            }
        });
    }
}
