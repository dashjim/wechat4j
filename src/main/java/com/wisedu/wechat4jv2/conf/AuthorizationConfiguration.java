package com.wisedu.wechat4jv2.conf;

public interface AuthorizationConfiguration {
    String getTokenURL();

    String getAuthToken();

    String getAuthAppId();

    String getAuthAppSecret();

    String getAuthAccessToken();
}
