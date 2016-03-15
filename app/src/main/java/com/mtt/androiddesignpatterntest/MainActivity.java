package com.mtt.androiddesignpatterntest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mtt.androiddesignpatterntest.mvc.controller.FirstActivity;
import com.mtt.androiddesignpatterntest.mvp1.ui.activity.SecondActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        Button btn_mvc = (Button) findViewById(R.id.btn_main_mvc);
        btn_mvc.setOnClickListener(this);
        Button btn_mvp1 = (Button) findViewById(R.id.btn_main_mvp1);
        btn_mvp1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_mvc:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.btn_main_mvp1:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
