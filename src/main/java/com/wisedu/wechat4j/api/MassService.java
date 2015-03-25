package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseUploadNews;

import java.io.IOException;
import java.util.Map;

public interface MassService {
    // 上传图文消息素材
    ResponseUploadNews uploadNews(Map<String, Object> news) throws IOException;
}
