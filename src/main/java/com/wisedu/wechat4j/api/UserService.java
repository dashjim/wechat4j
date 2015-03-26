package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;

import java.io.IOException;
import java.util.Map;

public interface UserService {
    // 设置备注名
    Response updateRemark(Map<String, Object> remark) throws IOException;
}
