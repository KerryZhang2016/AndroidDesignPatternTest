package com.mtt.androiddesignpatterntest.mvc.controller;

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
import com.mtt.androiddesignpatterntest.mvc.entity.PhoneMsg;
import com.mtt.androiddesignpatterntest.mvc.entity.PhoneMsgInfo;
import com.mtt.androiddesignpatterntest.mvc.model.OnPhoneMsgListener;
import com.mtt.androiddesignpatterntest.mvc.model.PhoneMsgModel;
import com.mtt.androiddesignpatterntest.mvc.model.PhoneMsgModelImpl;

/**
 * Description:MVC模式下的Controller，同时负责View的显示
 * Created by Kerry on 16/3/14.
 */
public class FirstActivity extends AppCompatActivity implements OnPhoneMsgListener, View.OnClickListener{

    private PhoneMsgModel phoneMsgModel;

    private Dialog loadingDialog;
    private EditText edt_input;
    private TextView tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        phoneMsgModel = new PhoneMsgModelImpl();

        initUI();
    }

    private void initUI() {
        edt_input = (EditText) findViewById(R.id.edt_first);
        tv_result = (TextView) findViewById(R.id.tv_first_result);
        Button btn_go = (Button) findViewById(R.id.btn_first_go);
        btn_go.setOnClickListener(this);

        loadingDialog = new ProgressDialog(FirstActivity.this);
        loadingDialog.setTitle("加载信息中...");
    }

    /**
     * 显示结果
     * */
    public void displayResult(PhoneMsg phoneMsg) {
        PhoneMsgInfo phoneMsgInfo = phoneMsg.getShowapi_res_body();
        tv_result.setText("名称  "+phoneMsgInfo.getName()+"\n"+"号码  "+
                phoneMsgInfo.getNum()+"\n"+"省份  "+
                phoneMsgInfo.getProv()+"\n"+"省份编号  "+
                phoneMsgInfo.getProvCode()+"\n"+"code  "+
                phoneMsgInfo.getRet_code()+"\n"+"类型  "+
                phoneMsgInfo.getType());
    }

    /**
     * 隐藏进度对话框，同时隐藏软键盘
     * */
    public void hideLoadingDialog() {
        if(loadingDialog != null) {
            loadingDialog.dismiss();
        }
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()){
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first_go:
                loadingDialog.show();
                if(phoneMsgModel != null) {
                    phoneMsgModel.getPhoneMsg(edt_input.getText().toString().trim(),this);
                }
                break;
        }
    }

    @Override
    public void onSuccess(PhoneMsg phoneMsg) {
        hideLoadingDialog();
        displayResult(phoneMsg);
    }

    @Override
    public void onError() {
        hideLoadingDialog();
        Toast.makeText(this,"信息获取失败",Toast.LENGTH_SHORT).show();
    }
}
