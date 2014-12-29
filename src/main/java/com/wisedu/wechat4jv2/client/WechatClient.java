package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4jv2.api.WechatSupport;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.conf.ConfigurationContext;
import com.wisedu.wechat4jv2.entity.AccessToken;
import com.wisedu.wechat4jv2.entity.ObjectFactory;

import java.io.IOException;

public class WechatClient extends WechatBaseClient implements WechatSupport{
    private AccessToken token;
    private ObjectFactory factory;

    public WechatClient() {
        this(ConfigurationContext.getInstance());
    }

    public WechatClient(Configuration conf) {
        initialize(conf);
        this.factory = new ObjectFactory();
        this.token = factory.createAccessToken(conf.getAuthAccessToken(), null);
    }

    public WechatClient(String appId, String appSecret) {
        initialize(appId, appSecret);
        this.factory = new ObjectFactory();
        this.token =  factory.createAccessToken(conf.getAuthAccessToken(), null);
    }

    @Override public void setOAuthAppId(String appId, String appSecret) {

    }

    @Override public void setAuthAppAccessToken(String accessToken, Long expiresIn) {

    }

    @Override public AccessToken getAuthAppAccessToken() throws IOException {
        return null;
    }
}
