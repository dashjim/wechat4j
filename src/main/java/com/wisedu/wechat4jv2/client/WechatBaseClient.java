package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4jv2.auth.AuthSupport;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.conf.ConfigurationBuilder;
import com.wisedu.wechat4jv2.enity.ObjectFactory;
import com.wisedu.wechat4jv2.http.HttpClient;
import com.wisedu.wechat4jv2.http.HttpClientFactory;
import com.wisedu.wechat4jv2.http.HttpParameter;
import com.wisedu.wechat4jv2.http.HttpResponse;

import java.io.IOException;

abstract class WechatBaseClient {
    protected Configuration conf;
    protected HttpClient http;
    protected AuthSupport auth;
    protected ObjectFactory factory;

    protected final void initialize(Configuration conf) {
        this.conf = conf;
        this.http = HttpClientFactory.getInstance(conf);
    }

    protected final void initialize(String appId, String appSecret) {
        this.conf = new ConfigurationBuilder()
                .setAuthAppId(appId).setAuthAppSecret(appSecret).build();
        this.http = HttpClientFactory.getInstance(conf);
    }

    protected final HttpResponse get(String url, HttpParameter[] params) throws IOException {
        return http.get(url, params);
    }

    protected final HttpResponse post(String url, HttpParameter[] params) throws IOException{
        return http.post(url, params);
    }
}
