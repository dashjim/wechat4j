package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.internal.http.HttpResponse;
import com.wisedu.wechat4j.internal.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;

public final class AccessToken implements Serializable {
    private static final long serialVersionUID = -7642817790672933689L;

    private String token;
    private Long expires;
    private Response response;

    public AccessToken(String token, Long expires) {
        this.token = token;
        this.expires = expires;
    }

    public AccessToken(HttpResponse response) throws IOException {
        this(response.asJSONObject());
    }

    AccessToken(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("access_token")) {
            this.token = jsonObject.getString("access_token");
        }
        if (!jsonObject.isNull("expires_in")) {
            this.expires = jsonObject.getLong("expires_in");
        }
    }

    public Long getExpires() {
        return expires;
    }

    public String getToken() {
        return token;
    }

    public Response getResponse() {
        return response;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessToken that = (AccessToken) o;

        if (expires != null ? !expires.equals(that.expires) : that.expires != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = expires != null ? expires.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        if (response != null) {
            return response.toString();
        } else {
            return "{\"menu\": {}}";
        }
    }
}
