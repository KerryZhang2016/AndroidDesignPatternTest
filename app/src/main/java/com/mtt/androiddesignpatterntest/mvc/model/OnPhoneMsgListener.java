package com.mtt.androiddesignpatterntest.mvc.model;

import com.mtt.androiddesignpatterntest.mvc.entity.PhoneMsg;

/**
 * Description:得到网络请求结果接口
 * Created by Kerry on 16/3/14.
 */
public interface OnPhoneMsgListener {

    void onSuccess(PhoneMsg phoneMsg);

    void onError();
}
