package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.conf.ConfigurationBuilder;
import com.wisedu.wechat4jv2.conf.ConfigurationContext;

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
