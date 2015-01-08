package com.wisedu.wechat4jv2.conf;

public interface AuthorizationConfiguration {
    String getTokenURL();

    String getAuthToken();

    String getAuthAppID();

    String getAuthAppSecret();

    String getAuthAccessToken();
}
