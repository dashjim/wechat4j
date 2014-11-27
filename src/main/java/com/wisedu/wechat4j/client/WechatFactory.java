package com.wisedu.wechat4j.client;

import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.conf.ConfigurationContext;

import java.io.Serializable;

public final class WechatFactory implements Serializable {
    private static final long serialVersionUID = 3863069838898599852L;

    private static final Configuration conf;
    static {
        conf = ConfigurationContext.getInstance();
    }

    private WechatFactory() { }

    public static Wechat createWechatInstance() {
        return createWechatInstance(conf);
    }

    public static Wechat createWechatInstance(Configuration conf) {
        return new WechatImpl(conf);
    }
}
