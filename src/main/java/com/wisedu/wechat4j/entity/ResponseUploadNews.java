package com.wisedu.wechat4j.entity;

public interface ResponseUploadNews {
    String getType();

    String getMediaId();

    Long getCreateTime();

    Response getResponse();
}
