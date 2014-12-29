package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

public interface AccessToken {
    String getCredential();

    Long getExpiresIn();

    JSONObject getObject();
}