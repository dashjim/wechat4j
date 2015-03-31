package com.wisedu.wechat4j.entity;

public interface ResponseTicket {
    String getTicket();

    Integer getExpireSeconds();

    String getURL();

    Response getResponse();
}
