package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseUploadNews;

import java.io.IOException;
import java.util.Map;

public interface MassService {
    // 上传图文消息素材
    ResponseUploadNews uploadNews(Map<String, Object> news) throws IOException;

    // 根据分组进行群发
    Response sendAll(Map<String, Object> news) throws IOException;
}
