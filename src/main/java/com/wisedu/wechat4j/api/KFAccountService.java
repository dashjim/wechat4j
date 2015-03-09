package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;

import java.io.IOException;
import java.util.Map;

public interface KFAccountService {
    // 添加客服帐号
    Response createKFAccount(Map<String, Object> kfAccount) throws IOException;

    // 修改客服账号
    Response updateKFAccount(Map<String, Object> kfAccount) throws IOException;

    // 获取所有客服账号
    Response listKFAccount() throws IOException;

    // 客服接口-发消息
    Response sendMessage(Map<String, Object> message) throws IOException;
}
