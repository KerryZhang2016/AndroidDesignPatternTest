package com.mtt.androiddesignpatterntest.mvp1.model.entity;

import java.io.Serializable;

/**
 * Description: 归属地详细信息实体
 * Created by Kerry on 16/3/14.
 */
public class PhoneMsgInfo implements Serializable{

    private String name;
    private int num;
    private String prov;
    private String provCode;
    private int ret_code;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
