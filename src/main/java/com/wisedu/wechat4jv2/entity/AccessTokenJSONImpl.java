package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class AccessTokenJSONImpl implements AccessToken, Serializable {
    private static final long serialVersionUID = 4599812481189485000L;

    private String token;
    private Long expiresIn;
    private String refreshToken;
    private String openId;
    private String scope;

    private JSONObject object;

    AccessTokenJSONImpl(String token, Long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.object = new JSONObject(
                "{\"access_token\": \"" + this.token + "\",  \"expires_in\": " + this.expiresIn + "}"
        );
    }

    AccessTokenJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("access_token")){
            this.token = jsonObject.getString("access_token");
        }
        if (!jsonObject.isNull("expires_in")) {
            this.expiresIn = jsonObject.getLong("expires_in");
        }
        if (!jsonObject.isNull("refresh_token")) {
            this.refreshToken = jsonObject.getString("refresh_token");
        }
        if (!jsonObject.isNull("openid")) {
            this.openId = jsonObject.getString("openid");
        }
        if (!jsonObject.isNull("scope")) {
            this.scope = jsonObject.getString("scope");
        }
    }

    @Override public String getToken() {
        return token;
    }

    @Override public Long getExpiresIn() {
        return expiresIn;
    }

    @Override public String getRefreshToken() {
        return refreshToken;
    }

    @Override public String getOpenId() {
        return openId;
    }

    @Override public String getScope() {
        return scope;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        AccessTokenJSONImpl that = (AccessTokenJSONImpl)o;

        if (token !=null? !token.equals(that.token): that.token !=null) return false;
        if (expiresIn!=null? !expiresIn.equals(that.expiresIn): that.expiresIn!=null) return false;
        if (refreshToken!=null? !refreshToken.equals(that.refreshToken): that.refreshToken!=null) return false;
        if (openId!=null? !openId.equals(that.openId): that.openId!=null) return false;
        if (scope!=null? !scope.equals(that.scope): that.scope!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (token !=null? token.hashCode(): 0);
        result = 31*result + (expiresIn!=null? expiresIn.hashCode(): 0);
        result = 31*result + (refreshToken!=null? refreshToken.hashCode(): 0);
        result = 31*result + (openId!=null? openId.hashCode(): 0);
        result = 31*result + (scope!=null? scope.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return object.toString();
    }
}
