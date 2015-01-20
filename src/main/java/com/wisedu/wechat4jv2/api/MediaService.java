package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.ResponseFileStream;
import com.wisedu.wechat4jv2.entity.ResponseMedia;

import java.io.File;
import java.io.IOException;

public interface MediaService {
    public ResponseMedia mediaUpload(String type, File file) throws IOException;

    public ResponseFileStream mediaDownload(String mediaId) throws IOException;

    public ResponseFileStream mediaDownload(String mediaId, File file) throws IOException;
}
