package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

final class ResponseFileJSONImpl implements ResponseFile, Serializable {
    private static final long serialVersionUID = 1624703790249232252L;

    private File file = null;
    private Response response = null;

    ResponseFileJSONImpl(HttpResponse response, File file) throws IOException {
        init(response, file);
    }

    private void init(HttpResponse response, File file) throws IOException {
        String contentType = response.getResponseHeader("content-type");
        if (!contentType.equals("text/plain")) {
            this.file = response.asFile(file);
            this.response = new ResponseJSONImpl(0, "ok");
        } else {
            this.response = new ResponseJSONImpl(response);
        }
    }

    @Override public File getFile() {
        return this.file;
    }

    @Override public Response getResponse() {
        return this.response;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        ResponseFileJSONImpl that = (ResponseFileJSONImpl)o;

        if (file!=null? !file.equals(that.file): that.file!=null) return false;
        if (response!=null? !response.equals(that.response): that.response!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (file!=null?file.hashCode(): 0);
        result = 31*result + (response!=null? response.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return this.response.toString();
    }
}
