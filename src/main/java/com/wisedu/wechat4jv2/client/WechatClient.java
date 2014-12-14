package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4jv2.api.WechatSupport;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.conf.ConfigurationContext;
import com.wisedu.wechat4jv2.enity.AccessToken;
import com.wisedu.wechat4jv2.enity.ObjectFactory;
import com.wisedu.wechat4jv2.http.HttpParameter;

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
        this.token = new AccessToken(conf.getAuthAccessToken(), null);
    }

    public WechatClient(String appId, String appSecret) {
        initialize(appId, appSecret);
        this.factory = new ObjectFactory();
        this.token = new AccessToken(conf.getAuthAccessToken(), null);
    }

    @Override public void setAuthAccessToken(String accessToken, Long expiresIn) {
        this.token = new AccessToken(accessToken, expiresIn);
    }

    @Override public AccessToken getAuthAccessToken() throws IOException {
        String url = conf.getRestBaseURL() + "token";
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("appid", conf.getAuthAppID()),
                new HttpParameter("secret", conf.getAuthAppSecret()),
                new HttpParameter("grant_type", "client_credential")
        };
        this.token = factory.createAccessToken(get(url, params));
        return token;
    }
}
