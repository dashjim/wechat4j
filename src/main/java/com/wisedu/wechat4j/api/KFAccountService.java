package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseKFAccountCollection;
import com.wisedu.wechat4j.entity.ResponseMessage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface KFAccountService {
    // 添加客服帐号
    Response createKFAccount(Map<String, Object> kfAccount) throws IOException;

    // 修改客服账号
    Response updateKFAccount(Map<String, Object> kfAccount) throws IOException;

    // 删除客服账号
    Response deleteKFAccount(Map<String, Object> kfAccount) throws IOException;

    // 设置客服帐号的头像
    Response uploadHeadImage(String kfAccount, File image) throws Exception;

    // 获取所有客服账号
    ResponseKFAccountCollection listKFAccount() throws IOException;

    // 客服接口-发消息
    Response sendMessage(Map<String, Object> message) throws IOException;
}
