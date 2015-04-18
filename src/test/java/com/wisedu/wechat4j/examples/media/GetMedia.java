package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.io.File;

// 获取临时素材
public class GetMedia {
    private static final String media = GetMedia.class.getResource("/").getPath() + "download.png";
    private static final String mediaId = "xH6SeojUsY2lTpx-X0YTHcm1vjOamOhY-9Kdf1_2O3iL-q0tMSifZmBN0Bc54_vh";

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.getMedia(mediaId, new File(media));
        if (response.getErrCode() == 0){
            System.out.println("Get Media Succeed." + response);
        } else {
            System.err.println("Get Media Failed." + response);
        }
    }
}
