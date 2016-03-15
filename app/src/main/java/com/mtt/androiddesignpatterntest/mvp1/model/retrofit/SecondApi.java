package com.mtt.androiddesignpatterntest.mvp1.model.retrofit;

import com.mtt.androiddesignpatterntest.mvc.entity.Weather;
import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsg;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Description: mvc test api
 * Created by Kerry on 16/3/14.
 */
public interface SecondApi {

    @GET("/sk/{cityNumber}.html")
    Call<Weather> getWeather(@Path("cityNumber") String cityNumber);

    @GET("find")
    Call<PhoneMsg> getPhoneMsg(@Header("apikey") String apikey,
                               @Query("num") String num);
}
