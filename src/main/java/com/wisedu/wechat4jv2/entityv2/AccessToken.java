package com.wisedu.wechat4jv2.entityv2;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

public class AccessToken implements Serializable {
    private String credential;
    private Long expiresIn;

    private JSONObject object;

    public AccessToken(String credential, Long expiresIn) {

    }

    public String getCredential() {
        return credential;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public JSONObject getObject() {
        return object;
    }

    @Override public String toString() {
        return object.toString();
    }

    class AccessTokenBuilder {
        private String credential;
        private Long expiresIn;

        private JSONObject object;

        AccessTokenBuilder() {
            this.object = new JSONObject();
        }

        AccessTokenBuilder setCredential(String credential) {
            this.credential = credential;
            this.object.put("access_token", this.credential);
            return this;
        }

        AccessTokenBuilder setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
            this.object.put("expires_in", expiresIn);
            return this;
        }

        AccessToken build() {
            return null;
        }
    }
}
