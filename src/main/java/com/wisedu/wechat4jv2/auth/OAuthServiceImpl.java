package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.conf.AuthorizationConfiguration;
import com.wisedu.wechat4jv2.entity.ObjectFactory;
import com.wisedu.wechat4jv2.http.HttpClient;

import java.io.Serializable;

final class OAuthServiceImpl implements Serializable {
    private String appId;
    private String appSecret;
    private AuthorizationConfiguration config;
    private HttpClient http;
    private ObjectFactory factory;
}
