package com.wisedu.wechat4j.entity;

public interface ResponseMassMessage {
    Long getMessageId();

    String getStatus();

    Response getResponse();
}
