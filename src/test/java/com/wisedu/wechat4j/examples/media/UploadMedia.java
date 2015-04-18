package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.io.File;

// 新增临时素材
public class UploadMedia {
    private static final String media
            = UploadMedia.class.getResource("/").getPath() + "upload.png";

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia response = wechat.uploadMedia("image", new File(media));
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Upload Media Succeed." + response);
        } else {
            System.err.println("Upload Media Failed." + response);
        }
    }
}
