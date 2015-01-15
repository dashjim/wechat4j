package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.Response;
import com.wisedu.wechat4jv2.entity.ResponseMedia;

import java.io.File;
import java.io.IOException;

public interface MediaSupport {
    public ResponseMedia mediaUpload(String type, File file) throws IOException;

    public Response mediaDownload(String mediaId);
}
