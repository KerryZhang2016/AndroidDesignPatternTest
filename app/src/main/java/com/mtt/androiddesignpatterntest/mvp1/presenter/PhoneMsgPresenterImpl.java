package com.mtt.androiddesignpatterntest.mvp1.presenter;

import com.mtt.androiddesignpatterntest.mvp1.model.PhoneMsgModel;
import com.mtt.androiddesignpatterntest.mvp1.model.PhoneMsgModelImpl;
import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsg;
import com.mtt.androiddesignpatterntest.mvp1.ui.view.PhoneMsgView;

/**
 * Description: 手机归属地 Presenter 实现
 * Created by Kerry on 16/3/15.
 */
public class PhoneMsgPresenterImpl implements PhoneMsgPresenter, OnPhoneMsgListener{

    private PhoneMsgModel phoneMsgModel;
    private PhoneMsgView phoneMsgView;


    public PhoneMsgPresenterImpl(PhoneMsgView phoneMsgView) {
        phoneMsgModel = new PhoneMsgModelImpl();
        this.phoneMsgView = phoneMsgView;
    }

    @Override
    public void getPhoneMsg(String num) {
        if(phoneMsgModel != null) {
            phoneMsgModel.getPhoneMsg(num,this);
        }
        if(phoneMsgView != null) {
            phoneMsgView.showLoading();
        }
    }

    @Override
    public void onDestroy() {
        phoneMsgView = null;
    }

    @Override
    public void onSuccess(PhoneMsg phoneMsg) {
        // view 层做响应
        if(phoneMsgView != null) {
            phoneMsgView.hideLoading();
            phoneMsgView.setPhoneMsgInfo(phoneMsg);
        }
    }


    @Override
    public void onError() {
        // view 层做响应
        if(phoneMsgView != null) {
            phoneMsgView.hideLoading();
            phoneMsgView.showError();
        }
    }
}
