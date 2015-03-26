package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseMedia;
import com.wisedu.wechat4j.entity.ResponseMessage;
import com.wisedu.wechat4j.entity.ResponseTemplate;

import java.io.IOException;
import java.util.Map;

public interface TemplateService {
    // 设置所属行业
    Response setIndustry(Map<String, Object> industry) throws IOException;

    // 获得模板ID
    ResponseTemplate addTemplate(Map<String, Object> template) throws IOException;

    // 发送模板消息
    ResponseMessage sendTemplateMessage(Map<String, Object> template) throws IOException;
}
