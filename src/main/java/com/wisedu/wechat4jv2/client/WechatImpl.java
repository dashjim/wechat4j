package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4j.internal.json.JSONObject;
import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.entity.*;
import com.wisedu.wechat4jv2.http.HttpClient;
import com.wisedu.wechat4jv2.http.HttpClientFactory;
import com.wisedu.wechat4jv2.http.HttpParameter;
import com.wisedu.wechat4jv2.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

final class WechatImpl implements Wechat, Serializable {
    private static final long serialVersionUID = 8970456419937426235L;

    private Configuration conf;
    private HttpClient http;
    private ObjectFactory factory;

    private AccessToken accessToken;

    WechatImpl(Configuration conf) {
        this.conf = conf;
        init(conf);
    }

    private void init(Configuration conf) {
        setHttp();
        setFactory();
        setToken();
    }

    private void setHttp() {
        this.http = HttpClientFactory.getInstance(conf);
    }

    private void setFactory() {
        this.factory = new ObjectFactory();
    }

    private void setToken() {
        String credential = conf.getOAuthAppCredential();
        if (credential != null) {
            this.accessToken = factory.createAccessToken(credential, null);
        }
    }

    private HttpResponse get(String url, HttpParameter[] params) throws IOException {
        return http.get(url, params);
    }

    private HttpResponse post(String url, HttpParameter[] params) throws IOException{
        return http.post(url, params);
    }

    @Override public ResponseMedia mediaUpload(String type, File file) throws IOException{
        String url = conf.getMediaBaseURL() + "/upload"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("type", type),
                new HttpParameter("media", file)
        };
        return factory.createResponseMedia(post(url, params));
    }

    @Override public ResponseFileStream mediaDownload(String mediaId) throws IOException {
        String url = conf.getMediaBaseURL() + "/get"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("media_id", mediaId)
        };
        return factory.createResponseFileStream(post(url, params));
    }

    @Override public ResponseFileStream mediaDownload(String mediaId, File file) throws IOException {
        return null;
    }

    @Override public ResponseAccessToken getAccessToken() throws IOException{
        String url = conf.getRestBaseURL() + "/token";
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("grant_type", "client_credential"),
                new HttpParameter("appid", conf.getOAuthAppId()),
                new HttpParameter("secret", conf.getOAuthAppSecret())
        };
        ResponseAccessToken responseAccessToken
                = factory.createResponseAccessToken(get(url, params));
        this.accessToken = responseAccessToken.getAccessToken();
        return responseAccessToken;
    }

    @Override public void setAccessToken(String credential, Long expiresIn) {
        this.accessToken = factory.createAccessToken(credential, expiresIn);
    }

    @Override public ResponseGroup createGroup(Map<String, Object> group) throws IOException{
        String url = conf.getRestBaseURL() + "/groups/create"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponseGroup(post(url, params));
    }

    @Override public ResponseGroupCollection listGroup() throws IOException{
        String url = conf.getRestBaseURL() + "/groups/get";
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("access_token", accessToken.getCredential())
        };
        return factory.createResponseGroupCollection(get(url, params));
    }

    @Override public ResponseGroupCollection listGroup(Map<String, Object> users) {
        return null;
    }

    @Override public Response updateGroup(Map<String, Object> group) {
        return null;
    }

    @Override public Response moveGroup(Map<String, Object> msg) {
        return null;
    }
}
