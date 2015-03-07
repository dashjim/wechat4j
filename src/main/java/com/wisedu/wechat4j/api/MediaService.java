package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseFile;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.io.File;
import java.io.IOException;

public interface MediaService {
    // 上传多媒体文件
    public ResponseMedia mediaUpload(String type, File file) throws IOException;

    // 下载多媒体文件
    public ResponseFile mediaDownload(String mediaId, File file) throws IOException;
}
