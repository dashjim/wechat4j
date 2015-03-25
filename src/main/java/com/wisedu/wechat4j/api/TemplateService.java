package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;

import java.io.IOException;
import java.util.Map;

public interface TemplateService {
    // 设置所属行业
    Response setIndustry(Map<String, Object> industry) throws IOException;
}
