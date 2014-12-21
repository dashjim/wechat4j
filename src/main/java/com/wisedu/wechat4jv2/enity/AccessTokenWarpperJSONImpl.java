package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class AccessTokenWarpperJSONImpl implements AccessTokenWarpper, Serializable {
    private AccessToken_ accessToken;

    private Response response;

    AccessTokenWarpperJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    AccessTokenWarpperJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("access_token")) {
            this.accessToken = new AccessTokenJSONImpl(jsonObject);
        }
    }

    @Override public AccessToken_ getAccessToken() {
        return accessToken;
    }

    @Override public Response getResponse() {
        return response;
    }

    @Override public String toString() {
        return response.toString();
    }
}
