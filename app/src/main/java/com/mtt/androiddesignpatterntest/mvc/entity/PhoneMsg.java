package com.mtt.androiddesignpatterntest.mvc.entity;

import java.io.Serializable;

/**
 * Description: 返回实体
 * Created by Kerry on 16/3/14.
 */
public class PhoneMsg implements Serializable{

    private int showapi_res_code;

    private String showapi_res_error;

    private PhoneMsgInfo showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public PhoneMsgInfo getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(PhoneMsgInfo showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
}
