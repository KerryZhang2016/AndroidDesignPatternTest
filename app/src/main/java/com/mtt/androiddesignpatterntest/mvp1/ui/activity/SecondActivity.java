package com.mtt.androiddesignpatterntest.mvp1.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mtt.androiddesignpatterntest.R;
import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsg;
import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsgInfo;
import com.mtt.androiddesignpatterntest.mvp1.presenter.PhoneMsgPresenter;
import com.mtt.androiddesignpatterntest.mvp1.presenter.PhoneMsgPresenterImpl;
import com.mtt.androiddesignpatterntest.mvp1.ui.view.PhoneMsgView;

/**
 * Description: mvp1 demo activity
 * Created by Kerry on 16/3/15.
 */
public class SecondActivity extends AppCompatActivity implements PhoneMsgView, View.OnClickListener{

    private Dialog loadingDialog;
    private EditText edt_input;
    private TextView tv_result;

    private PhoneMsgPresenter phoneMsgPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        initUI();
        phoneMsgPresenter = new PhoneMsgPresenterImpl(this);
    }

    private void initUI() {
        edt_input = (EditText) findViewById(R.id.edt_demo);
        tv_result = (TextView) findViewById(R.id.tv_demo_result);
        Button btn_go = (Button) findViewById(R.id.btn_demo_go);
        btn_go.setOnClickListener(this);

        loadingDialog = new ProgressDialog(SecondActivity.this);
        loadingDialog.setTitle("加载信息中...");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_demo_go:
                if(phoneMsgPresenter != null) {
                    phoneMsgPresenter.getPhoneMsg(edt_input.getText().toString().trim());
                }
                break;
        }
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()){
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this,"信息获取失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPhoneMsgInfo(PhoneMsg phoneMsg) {
        PhoneMsgInfo phoneMsgInfo = phoneMsg.getShowapi_res_body();
        tv_result.setText("名称  "+phoneMsgInfo.getName()+"\n"+"号码  "+
                phoneMsgInfo.getNum()+"\n"+"省份  "+
                phoneMsgInfo.getProv()+"\n"+"省份编号  "+
                phoneMsgInfo.getProvCode()+"\n"+"code  "+
                phoneMsgInfo.getRet_code()+"\n"+"类型  "+
                phoneMsgInfo.getType());
    }
}
