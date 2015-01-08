package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.conf.AuthorizationConfiguration;
import com.wisedu.wechat4jv2.http.HttpClient;

import java.io.Serializable;

final class OAuthServiceImpl implements Serializable {
    private HttpClient http;
    private AuthorizationConfiguration config;
}
