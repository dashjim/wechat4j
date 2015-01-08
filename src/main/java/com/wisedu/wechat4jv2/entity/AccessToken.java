package com.wisedu.wechat4jv2.entity;

public interface AccessToken {
    String getToken();

    Long getExpiresIn();

    String getRefreshToken();

    String getOpenId();

    String getScope();
}