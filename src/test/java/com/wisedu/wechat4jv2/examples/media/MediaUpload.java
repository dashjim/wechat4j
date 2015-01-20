package com.wisedu.wechat4jv2.examples.media;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseMedia;

import java.io.File;
import java.io.IOException;

public class MediaUpload {
    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia media = wechat.mediaUpload("image", new File("D:/baidu.png"));
        if (media.getResponse().getErrCode() == null){
            System.out.println("Media Upload Succeed." + media);
        } else {
            System.err.println("Media Upload Failed." + media);
        }
    }
}
