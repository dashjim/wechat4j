package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.io.File;

// 设置客服帐号的头像
public class UploadHeadImage {
    private static final String kfAccount = "test123@gh_57372a9ae6a9";
    private static final String headImage= UploadHeadImage.class.getResource("/").getPath() + "avatar.png";

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.uploadHeadImage(kfAccount, new File(headImage));
        if (response.getErrCode() == 0){
            System.out.println("Upload Head Image Succeed." + response);
        } else {
            System.err.println("Upload Head Image Failed." + response);
        }
    }
}
