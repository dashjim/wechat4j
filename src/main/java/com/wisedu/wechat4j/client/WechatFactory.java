package com.wisedu.wechat4j.client;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.conf.ConfigurationBuilder;
import com.wisedu.wechat4j.conf.ConfigurationContext;

public class WechatFactory {
    private static final Configuration conf;

    static {
        conf = ConfigurationContext.getInstance();
    }

    public Wechat getInstance() {
        return this.getInstance(conf);
    }

    public Wechat getInstance(String appId, String appSecret) {
        return this.getInstance(
                new ConfigurationBuilder()
                        .setOAuthAppId(appId)
                        .setOAuthAppSecret(appSecret).build()
        );
    }

    public Wechat getInstance(Configuration conf) {
        return new WechatImpl(conf);
    }
}
