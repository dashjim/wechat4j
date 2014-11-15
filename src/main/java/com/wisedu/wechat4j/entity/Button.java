package com.wisedu.wechat4j.entity;

public interface Button{
    ButtonType getType();

    String getName();

    String getKey();

    String getURL();

    SubButton[] getSubButton();
}
