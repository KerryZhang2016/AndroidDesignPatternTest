package com.mtt.androiddesignpatterntest.mvp1.model;

import com.mtt.androiddesignpatterntest.mvp1.presenter.OnPhoneMsgListener;

/**
 * Description:
 * Created by Kerry on 16/3/14.
 */
public interface PhoneMsgModel {

    void getPhoneMsg(String num, OnPhoneMsgListener listener);

}
