package com.wisedu.wechat4jv2.entity;

public interface Button {
    String getType();

    String getName();

    String getUrl();

    String getKey();

    Button[] getSubButon();
}
