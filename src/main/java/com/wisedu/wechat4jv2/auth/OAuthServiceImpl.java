package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.conf.AuthorizationConfiguration;
import com.wisedu.wechat4jv2.entity.ObjectFactory;
import com.wisedu.wechat4jv2.entity.ResponseAccessToken;
import com.wisedu.wechat4jv2.http.HttpClient;
import com.wisedu.wechat4jv2.http.HttpParameter;

import java.io.IOException;
import java.io.Serializable;

final class OAuthServiceImpl implements OAuthService, Serializable {
    private static final long serialVersionUID = -2236330372261830175L;

    private String appId;
    private String appSecret;
    private AuthorizationConfiguration config;
    private HttpClient http;
    private ObjectFactory factory;

    @Override public ResponseAccessToken getAccessToken() throws IOException {
        String url = config.getTokenURL();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("grant_type", "client_credential"),
                new HttpParameter("appid", appId),
                new HttpParameter("secret", appSecret)
        };
        return factory.createResponseAccessToken(http.get(url, params));
    }
}
