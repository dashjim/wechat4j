package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseFile;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.io.File;

public class UploadDownloadMedia {
    private static final String src = UploadDownloadMedia.class.getResource("/").getPath() + "upload.png";
    private static final String dst = UploadDownloadMedia.class.getResource("/").getPath() + "download.png";

    public static void main(String[] args) throws Exception {
        // 上传多媒体文件
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia media = wechat.mediaUpload("image", new File(src));
        if (media.getResponse().getErrCode() == 0){
            System.out.println("Upload Media Succeed." + media);
        } else {
            System.err.println("Upload Media Failed." + media);
        }

        // 下载多媒体文件
        ResponseFile file = wechat.mediaDownload(media.getMedia().getMediaId(), new File(dst));
        if (file.getResponse().getErrCode() == 0){
            System.out.println("Download Media Succeed." + file);
        } else {
            System.err.println("Download Media Failed." + file);
        }
    }
}
