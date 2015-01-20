package com.wisedu.wechat4jv2.examples.media;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseFileStream;

import java.io.IOException;

public class MediaDownload {
    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseFileStream fileStream = wechat.mediaDownload("Rp7yW_H2DwsgGmXAle6t8PEpbgabR0c1Rr7rQhGJWsDg251Y5EtZl5kbH5BjNotG");
        if (fileStream.getInputStream() == null){
            System.out.println("Media Download Succeed." + fileStream);
        } else {
            System.err.println("Media Download Failed." + fileStream);
        }
    }
}
