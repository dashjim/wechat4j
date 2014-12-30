package com.wisedu.wechat4jv2.entity;

public interface ResponseUserCollection {
    Integer getTotal();

    Integer getCount();

    String[] getOpenIds();

    String getNextOpenId();

    Response getResponse();
}
