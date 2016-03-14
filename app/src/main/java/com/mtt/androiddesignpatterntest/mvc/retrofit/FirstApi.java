package com.mtt.androiddesignpatterntest.mvc.retrofit;

import com.mtt.androiddesignpatterntest.mvc.entity.Weather;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Description: mvc test api
 * Created by Kerry on 16/3/14.
 */
public interface FirstApi {

    @GET("/sk/{cityNumber}.html")
    Call<Weather> getWeather(@Path("cityNumber") String cityNumber);
}
