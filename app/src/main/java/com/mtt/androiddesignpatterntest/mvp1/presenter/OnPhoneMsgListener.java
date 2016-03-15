package com.mtt.androiddesignpatterntest.mvp1.presenter;


import com.mtt.androiddesignpatterntest.mvp1.model.entity.PhoneMsg;

/**
 * Description:得到网络请求结果接口
 * Created by Kerry on 16/3/14.
 */
public interface OnPhoneMsgListener {

    void onSuccess(PhoneMsg phoneMsg);

    void onError();
}
