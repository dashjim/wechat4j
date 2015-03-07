package com.wisedu.wechat4j.client;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.entity.*;
import com.wisedu.wechat4j.http.HttpClient;
import com.wisedu.wechat4j.http.HttpClientFactory;
import com.wisedu.wechat4j.http.HttpParameter;
import com.wisedu.wechat4j.http.HttpResponse;
import com.wisedu.wechat4j.internal.json.JSONObject;

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

    @Override public void setAccessToken(String credential, Long expiresIn) {
        this.accessToken = factory.createAccessToken(credential, expiresIn);
    }

    // 获取Access Token
    @Override public ResponseAccessToken getAccessToken() throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/token";
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

    // 上传多媒体文件
    @Override public ResponseMedia mediaUpload(String type, File file) throws IOException{
        String url = conf.getMediaBaseURL() + "/cgi-bin/media/upload"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("type", type),
                new HttpParameter("media", file)
        };
        return factory.createResponseMedia(post(url, params));
    }

    // 下载多媒体文件
    @Override public ResponseFile mediaDownload(String mediaId, File file) throws IOException {
        String url = conf.getMediaBaseURL() + "/cgi-bin/media/get"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("media_id", mediaId)
        };
        return factory.createResponseFile(post(url, params), file);
    }

    // 添加客服帐号
    @Override public Response createKfAccount(Map<String, Object> kfAccount) throws IOException {
        String url = conf.getRestBaseURL() + "/customservice/kfaccount/add"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(kfAccount))
        };
        return factory.createResponse(post(url, params));
    }

    // 获取所有客服账号
    @Override public Response listKfAccount() throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/customservice/getkflist"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
        };
        return factory.createResponse(post(url, params));
    }

    // 客服接口-发消息
    @Override public Response sendMessage(Map<String, Object> message) throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/message/custom/send"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(message))
        };
        return factory.createResponse(post(url, params));
    }

    @Override public ResponseGroup createGroup(Map<String, Object> group) throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/create"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponseGroup(post(url, params));
    }

    @Override public ResponseGroupCollection listGroup() throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/get";
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
