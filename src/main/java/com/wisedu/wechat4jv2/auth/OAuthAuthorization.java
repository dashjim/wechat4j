package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.conf.AuthorizationConfiguration;
import com.wisedu.wechat4jv2.entity.AccessToken;

import java.io.Serializable;

public final class OAuthAuthorization implements Serializable {
    private AccessToken accessToken;
    private AuthorizationConfiguration conf;

    public OAuthAuthorization(AuthorizationConfiguration conf) {
        this.conf = conf;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
