package com.wisedu.wechat4jv2.examples.media;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseFile;
import com.wisedu.wechat4jv2.entity.ResponseMedia;

import java.io.File;

public class Media {
    public static void main(String[] args) {
        try {
            // 上传多媒体文件
            Wechat wechat = new WechatFactory().getInstance();
            ResponseMedia media = wechat.mediaUpload("image", new File("D:/dog.png"));
            if (media.getResponse().getErrCode() == 0){
                System.out.println("Media Upload Succeed." + media);
            } else {
                System.err.println("Media Upload Failed." + media);
            }

            // 下载多媒体文件
            ResponseFile file = wechat.mediaDownload(media.getMedia().getMediaId(), new File("D:/dog_1.png"));
            if (file.getResponse().getErrCode() == 0){
                System.out.println("Media Download Succeed." + file);
            } else {
                System.err.println("Media Download Failed." + file);
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
