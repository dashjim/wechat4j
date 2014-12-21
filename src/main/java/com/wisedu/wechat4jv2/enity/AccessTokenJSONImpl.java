package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class AccessTokenJSONImpl implements AccessToken_, Serializable {
    private String credential;
    private Long expiresIn;

    private JSONObject object;

    AccessTokenJSONImpl(String credential, Long expiresIn) {
        this.credential = credential;
        this.expiresIn = expiresIn;
        this.object = null;
    }

    AccessTokenJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("access_token")){
            this.credential = jsonObject.getString("access_token");
        }
        if (!jsonObject.isNull("expires_in")) {
            this.expiresIn = jsonObject.getLong("expires_in");
        }
    }

    @Override public String getCredential() {
        return credential;
    }

    @Override public Long getExpiresIn() {
        return expiresIn;
    }

    @Override public JSONObject getObject() {
        return object;
    }
}
