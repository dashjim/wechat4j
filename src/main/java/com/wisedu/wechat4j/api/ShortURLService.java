package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseShortURL;

import java.io.IOException;
import java.util.Map;

public interface ShortURLService {
    // 将一条长链接转成短链接
    ResponseShortURL createShortURL(Map<String, Object> url) throws IOException;
}
