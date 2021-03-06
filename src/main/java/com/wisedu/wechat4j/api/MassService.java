package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseMessage;
import com.wisedu.wechat4j.entity.ResponseUploadNews;

import java.io.IOException;
import java.util.Map;

public interface MassService {
    // 上传图文消息素材
    ResponseUploadNews uploadNews(Map<String, Object> news) throws IOException;

    // 根据分组进行群发
    ResponseMessage massSendAll(Map<String, Object> msg) throws IOException;

    // 根据OpenID列表群发
    ResponseMessage massSend(Map<String, Object> msg) throws IOException;

    // 删除群发
    Response massDelete(Map<String, Object> msg) throws IOException;

    // 预览接口
    ResponseMessage massPreview(Map<String, Object> msg) throws IOException;

    // 查询群发消息发送状态
    ResponseMessage massGet(Map<String, Object> msg) throws IOException;
}
