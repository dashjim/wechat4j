package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.http.HttpResponse;
import com.wisedu.wechat4j.internal.json.JSONObject;

import java.io.Serializable;

final class ResponseMassMessageJSONImpl implements ResponseMassMessage, Serializable {
    private static final long serialVersionUID = 6695701615457520924L;

    private Long msgId;
    private String status;
    private Response response;

    ResponseMassMessageJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    ResponseMassMessageJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    private void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("msg_id")) {
            this.msgId = jsonObject.getLong("msg_id");
        }
        if (!jsonObject.isNull("msg_status")) {
            this.status = jsonObject.getString("msg_status");
        }
    }

    @Override public Long getMessageId() {
        return this.msgId;
    }

    @Override public String getStatus() {
        return this.status;
    }

    @Override public Response getResponse() {
        return this.response;
    }

    @Override public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        ResponseMassMessageJSONImpl that = (ResponseMassMessageJSONImpl)o;

        if (msgId!=null? !msgId.equals(that.msgId): that.msgId!=null) return false;
        if (status!=null? !status.equals(that.status): that.status!=null) return false;
        if (response!=null? !response.equals(that.response): that.response!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (msgId!=null? msgId.hashCode(): 0);
        result = 31*result + (status!=null? status.hashCode(): 0);
        result = 31*result + (response!=null? response.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return this.response.toString();
    }
}
