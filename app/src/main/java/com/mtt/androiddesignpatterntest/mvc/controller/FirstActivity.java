package com.mtt.androiddesignpatterntest.mvc.controller;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mtt.androiddesignpatterntest.R;
import com.mtt.androiddesignpatterntest.mvc.entity.Weather;
import com.mtt.androiddesignpatterntest.mvc.entity.WeatherInfo;
import com.mtt.androiddesignpatterntest.mvc.model.OnWeatherListener;
import com.mtt.androiddesignpatterntest.mvc.model.WeatherModel;
import com.mtt.androiddesignpatterntest.mvc.model.WeatherModelImpl;

/**
 * Description:MVC模式下的Controller，同时负责View的显示
 * Created by Kerry on 16/3/14.
 */
public class FirstActivity extends AppCompatActivity implements OnWeatherListener, View.OnClickListener{

    private WeatherModel weatherModel;

    private Dialog loadingDialog;
    private EditText edt_input;
    private TextView tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        weatherModel = new WeatherModelImpl();

        initUI();
    }

    private void initUI() {
        edt_input = (EditText) findViewById(R.id.edt_first);
        tv_result = (TextView) findViewById(R.id.tv_first_result);
        Button btn_go = (Button) findViewById(R.id.btn_first_go);
        btn_go.setOnClickListener(this);

        loadingDialog = new ProgressDialog(FirstActivity.this);
        loadingDialog.setTitle("加载天气中...");
    }

    /**
     * 显示结果
     * */
    public void displayResult(Weather weather) {
        WeatherInfo weatherInfo = weather.getWeatherInfo();
        tv_result.setText(weatherInfo.getCity()+","+
                weatherInfo.getCityid()+","+
                weatherInfo.getTemp()+","+
                weatherInfo.getWD()+","+
                weatherInfo.getWS()+","+
                weatherInfo.getSD()+","+
                weatherInfo.getWSE()+","+
                weatherInfo.getTime()+","+
                weatherInfo.getNjd());
    }

    /**
     * 隐藏进度对话框
     * */
    public void hideLoadingDialog() {
        if(loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first_go:
                loadingDialog.show();
                if(weatherModel != null) {
                    weatherModel.getWeather(edt_input.getText().toString().trim(),this);
                }
                break;
        }
    }

    @Override
    public void onSuccess(Weather weather) {
        hideLoadingDialog();
        displayResult(weather);
    }

    @Override
    public void onError() {
        hideLoadingDialog();
        Toast.makeText(this,"天气信息获取失败",Toast.LENGTH_SHORT).show();
    }
}
