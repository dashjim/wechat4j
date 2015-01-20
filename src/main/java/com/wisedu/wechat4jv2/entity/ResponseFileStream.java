package com.wisedu.wechat4jv2.entity;

import java.io.InputStream;

public interface ResponseFileStream {
    InputStream getInputStream();

    Response getResponse();
}
