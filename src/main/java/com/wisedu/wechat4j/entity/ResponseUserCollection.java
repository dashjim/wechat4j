package com.wisedu.wechat4j.entity;

public interface ResponseUserCollection {
    Integer getTotal();

    Integer getCount();

    String[] getOpenIds();

    String getNextOpenId();

    Response getResponse();
}
