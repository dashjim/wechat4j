package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4j.auth.Authorization;
import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.conf.ConfigurationBuilder;
import com.wisedu.wechat4j.internal.http.HttpClient;
import com.wisedu.wechat4j.internal.http.HttpClientFactory;

abstract class WechatBaseClient {
    private Configuration conf;
    private HttpClient http;
    private Authorization auth;

    WechatBaseClient(Configuration conf) {
        this.conf = conf;
    }

    WechatBaseClient(String appId, String appSecret) {
        this.conf = new ConfigurationBuilder()
                .setOAuthAppId(appId).setOAuthAppSecret(appSecret).build();
        this.http = HttpClientFactory.getInstance(conf);
    }
}
