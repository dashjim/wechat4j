package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

public interface Button {
    String getType();

    String getName();

    String getUrl();

    String getKey();

    Button[] getSubButon();

    JSONObject getObject();
}
