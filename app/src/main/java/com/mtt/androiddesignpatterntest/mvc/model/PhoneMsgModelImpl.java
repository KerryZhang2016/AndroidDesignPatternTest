package com.mtt.androiddesignpatterntest.mvc.model;

import android.util.Log;

import com.mtt.androiddesignpatterntest.mvc.entity.PhoneMsg;
import com.mtt.androiddesignpatterntest.mvc.retrofit.FirstApiClient;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Description:
 * Created by Kerry on 16/3/14.
 */
public class PhoneMsgModelImpl implements PhoneMsgModel {

    private static final String TAG = PhoneMsgModelImpl.class.getSimpleName();

    @Override
    public void getPhoneMsg(String num, final OnPhoneMsgListener listener) {
        FirstApiClient.getInstance().getPhoneMsg("368413272bac627f008f7d0e31c82e22", num, new Callback<PhoneMsg>() {
            @Override
            public void onResponse(Response<PhoneMsg> response, Retrofit retrofit) {
                Log.d(TAG, "----------------onResponse------------------");
                PhoneMsg phoneMsg = response.body();
                if(phoneMsg == null){
                    listener.onError();
                }else{
                    listener.onSuccess(phoneMsg);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "----------------onFailure------------------"+t.getMessage());
                listener.onError();
            }
        });
    }
}
