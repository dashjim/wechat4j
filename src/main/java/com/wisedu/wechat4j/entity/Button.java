package com.wisedu.wechat4j.entity;

public interface Button {
    String getType();

    String getName();

    String getUrl();

    String getKey();

    Button[] getButtons();
}
