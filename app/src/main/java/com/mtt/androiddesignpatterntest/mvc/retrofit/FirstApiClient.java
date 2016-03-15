package com.mtt.androiddesignpatterntest.mvc.retrofit;

import com.mtt.androiddesignpatterntest.converter.FastjsonConverterFactory;
import com.mtt.androiddesignpatterntest.mvc.entity.PhoneMsg;
import com.mtt.androiddesignpatterntest.mvc.entity.Weather;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Description: retrofit api client
 * Created by Kerry on 16/3/14.
 */
public class FirstApiClient {

    private static final String BASE_URL = "http://apis.baidu.com/showapi_open_bus/mobile/";
    private static FirstApiClient firstApiClient;
    private final FirstApi firstApi;
    private static OkHttpClient okHttpClient;

    public FirstApiClient() {
        okHttpClient = new OkHttpClient();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // add your other interceptors …
        // add logging as last interceptor
        okHttpClient.interceptors().add(logging);  // <-- this is the important line!

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

    /**
     * 手机归属地查询
     * */
    public void getPhoneMsg(String apikey, String num, Callback<PhoneMsg> callback) {
        firstApi.getPhoneMsg(apikey, num).enqueue(callback);
    }
}
