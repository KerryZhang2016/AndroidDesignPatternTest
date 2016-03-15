package com.mtt.androiddesignpatterntest.mvp1.presenter;

/**
 * Description: 手机归属地 Presenter 接口
 * Created by Kerry on 16/3/15.
 */
public interface PhoneMsgPresenter {

    /**
     * 获取手机归属地的逻辑
     * */
    void getPhoneMsg(String num);

    /**
     * 页面销毁时
     * */
    void onDestroy();
}
