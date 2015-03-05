package com.wisedu.wechat4jv2.conf;

import java.io.Serializable;

public interface Configuration extends Serializable,
        HttpClientConfiguration,
        AuthorizationConfiguration {
    boolean isDebugEnabled();

    String getLoggerFactory();

    String getRestBaseURL();

    String getMediaBaseURL();
}
