package com.wisedu.wechat4j.entity;

public interface ResponseMessage {
    Long getMessageId();

    String getStatus();

    Response getResponse();
}
