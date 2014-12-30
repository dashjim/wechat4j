package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class ResponseJSONImpl implements Response, Serializable {
    private static final long serialVersionUID = 6843993134093306504L;

    private Integer errCode;
    private String errMsg;

    protected JSONObject object;

    ResponseJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    ResponseJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("errcode")) {
            this.errCode = jsonObject.getInt("errcode");
        }
        if (!jsonObject.isNull("errmsg")) {
            this.errMsg = jsonObject.getString("errmsg");
        }
    }

    @Override public Integer getErrCode() {
        return errCode;
    }

    @Override public String getErrMsg() {
        return errMsg;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        ResponseJSONImpl that = (ResponseJSONImpl)o;

        if (errCode!=null? !errCode.equals(that.errCode): that.errCode!=null) return false;
        if (errMsg!=null? !errMsg.equals(that.errMsg): that.errMsg!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (errCode!=null? errCode.hashCode(): 0);
        result = 31*result + (errMsg!=null? errMsg.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return object.toString();
    }
}
