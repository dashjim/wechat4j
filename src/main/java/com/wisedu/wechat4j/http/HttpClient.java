package com.wisedu.wechat4j.http;

import java.io.IOException;

public interface HttpClient {
    HttpResponse get(String url) throws IOException;

    HttpResponse get(String url, HttpParameter[] params) throws IOException;

    HttpResponse post(String url) throws IOException;

    HttpResponse post(String url, HttpParameter[] params) throws IOException;

    HttpResponse delete(String url) throws IOException;

    HttpResponse delete(String url, HttpParameter[] params) throws IOException;

    HttpResponse put(String url) throws IOException;

    HttpResponse put(String url, HttpParameter[] params) throws IOException;
}
