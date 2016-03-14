package com.mtt.androiddesignpatterntest.mvc.retrofit;

import com.mtt.androiddesignpatterntest.converter.FastjsonConverterFactory;
import com.mtt.androiddesignpatterntest.mvc.entity.Weather;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Description: retrofit api client
 * Created by Kerry on 16/3/14.
 */
public class FirstApiClient {

    private static final String BASE_URL = "http://www.weather.com.cn/data";
    private static FirstApiClient firstApiClient;
    private final FirstApi firstApi;
    private static OkHttpClient okHttpClient;

    public FirstApiClient() {
        okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();
        firstApi = retrofit.create(FirstApi.class);
    }

    public static FirstApiClient getInstance() {
        if(firstApiClient == null){
            firstApiClient = new FirstApiClient();
        }
        return firstApiClient;
    }

    /**
     * 获取天气信息
     * */
    public void getWeather(String cityNumber, Callback<Weather> callback) {
        firstApi.getWeather(cityNumber).enqueue(callback);
    }
}
