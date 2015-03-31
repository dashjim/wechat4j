package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseTicket;

import java.io.IOException;
import java.util.Map;

public interface QRCodeService {
    // 创建二维码ticket
    ResponseTicket createTicket(Map<String, Object> ticket) throws IOException;
}
