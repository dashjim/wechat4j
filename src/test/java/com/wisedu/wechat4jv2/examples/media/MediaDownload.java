package com.wisedu.wechat4jv2.examples.media;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseFile;

import java.io.File;
import java.io.IOException;

public class MediaDownload {
    private static String media = "";
    private static String mediaId = "Rp7yW_H2DwsgGmXAle6t8PEpbgabR0c1Rr7rQhGJWsDg251Y5EtZl5kbH5BjNotG";

    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseFile file = wechat.mediaDownload(mediaId, new File(media));
        if (file.getResponse().getErrCode() == null){
            System.out.println("Media Download Succeed." + file);
        } else {
            System.err.println("Media Download Failed." + file);
        }
    }
}
