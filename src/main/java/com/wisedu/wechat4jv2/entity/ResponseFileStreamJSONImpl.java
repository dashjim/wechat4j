package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.http.HttpResponse;

import java.io.InputStream;
import java.io.Serializable;

final class ResponseFileStreamJSONImpl implements ResponseFileStream, Serializable {

    private InputStream is;
    private Response response;

    ResponseFileStreamJSONImpl(HttpResponse response) {
        init(response);
    }

    private void init(HttpResponse response) {
        String contentType = response.getResponseHeader("content-type");
        if (!contentType.equals("text/plain")) {
            this.is = response.asStream();
        } else {
            this.response = new ResponseJSONImpl(response.asJSONObject());
        }
    }

    @Override public InputStream getInputStream() {
        return is;
    }

    @Override public Response getResponse() {
        return response;
    }
}
