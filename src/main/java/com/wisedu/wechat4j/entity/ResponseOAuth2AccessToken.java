package com.wisedu.wechat4j.entity;

public interface ResponseOAuth2AccessToken {
    String getAccessToken();

    Integer getExpiresIn();

    String getRefreshToken();

    String getOpenId();

    String getScope();

    String getUnionId();

    Response getResponse();
}
