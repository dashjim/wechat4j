package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

final class AccessTokenJSONImpl implements AccessToken, Serializable {
    private static final long serialVersionUID = 4599812481189485000L;

    private String credential;
    private Long expiresIn;

    private JSONObject object;

    AccessTokenJSONImpl(String credential, Long expiresIn) {
        this.credential = credential;
        this.expiresIn = expiresIn;
        this.object = new JSONObject(
                "{\"access_token\": \"" + this.credential + "\",  \"expires_in\": " + this.expiresIn + "}"
        );
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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        AccessTokenJSONImpl that = (AccessTokenJSONImpl)o;

        if (credential!=null? !credential.equals(that.credential): that.credential!=null) return false;
        if (expiresIn!=null? !expiresIn.equals(that.expiresIn): that.expiresIn!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (credential!=null? credential.hashCode(): 0);
        result = 31*result + (expiresIn!=null? expiresIn.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return object.toString();
    }
}
