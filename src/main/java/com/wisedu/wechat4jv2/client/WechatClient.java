package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.conf.ConfigurationContext;
import com.wisedu.wechat4jv2.api.WechatSupport;

public class WechatClient extends WechatBaseClient implements WechatSupport{
    private static final Configuration conf;

    static {
        conf = ConfigurationContext.getInstance();
    }

    public WechatClient() {
        super(conf);
    }

    public WechatClient(Configuration conf) {
        super(conf);
    }

    public WechatClient(String appId, String appSecret) {
        super(appId, appSecret);
    }
}
