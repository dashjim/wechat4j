package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.http.HttpResponse;
import com.wisedu.wechat4j.internal.json.JSONArray;
import com.wisedu.wechat4j.internal.json.JSONObject;

import java.io.Serializable;
import java.util.Arrays;

final class ResponseKFAccountCollectionJSONImpl implements ResponseKFAccountCollection, Serializable {
    private static final long serialVersionUID = 8308072850055810925L;

    private KFAccount[] kfAccounts;
    private Response response;

    ResponseKFAccountCollectionJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    ResponseKFAccountCollectionJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    private void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("kf_list")) {
            JSONArray array = jsonObject.getJSONArray("kf_list");

            int size = array.length();
            kfAccounts = new KFAccount[size];
            for (int i=0; i<size; i++){
                kfAccounts[i] = new KFAccountJSONImpl(array.getJSONObject(i));
            }
        }
    }

    @Override public KFAccount[] getKFAccounts() {
        return kfAccounts;
    }

    @Override public Response getResponse() {
        return response;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        ResponseKFAccountCollectionJSONImpl that = (ResponseKFAccountCollectionJSONImpl)o;

        if (!Arrays.equals(kfAccounts, that.kfAccounts)) return false;
        if (response!=null? !response.equals(that.response): that.response!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (kfAccounts!=null? Arrays.hashCode(kfAccounts): 0);
        result = 31*result + (response!=null? response.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return response.toString();
    }
}
