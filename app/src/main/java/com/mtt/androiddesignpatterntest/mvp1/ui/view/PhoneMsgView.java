package com.mtt.androiddesignpatterntest.mvp1.ui.view;

import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsg;

/**
 * Description: 电话归属地 view 接口
 * Created by Kerry on 16/3/15.
 */
public interface PhoneMsgView {

    void showLoading();

    void hideLoading();

    void showError();

    void setPhoneMsgInfo(PhoneMsg phoneMsg);
}
