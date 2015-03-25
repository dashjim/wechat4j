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
        init(conf);
    }

    private void init(Configuration conf) {
        this.conf = conf;
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
    @Override public Response createKFAccount(Map<String, Object> kfAccount) throws IOException {
        String url = conf.getRestBaseURL() + "/customservice/kfaccount/add"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(kfAccount))
        };
        return factory.createResponse(post(url, params));
    }

    // 修改客服账号
    @Override public Response updateKFAccount(Map<String, Object> kfAccount) throws IOException{
        String url = conf.getRestBaseURL() + "/customservice/kfaccount/update"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(kfAccount))
        };
        return factory.createResponse(post(url, params));
    }

    // 删除客服账号
    @Override public Response deleteKFAccount(Map<String, Object> kfAccount) throws IOException {
        String url = conf.getRestBaseURL() + "/customservice/kfaccount/del"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(kfAccount))
        };
        return factory.createResponse(post(url, params));
    }

    // 设置客服帐号的头像
    @Override public Response uploadHeadImage(String kfAccount, File file) throws IOException{
        String url = conf.getRestBaseURL() + "/customservice/kfaccount/uploadheadimg"
                + "?access_token=" + accessToken.getCredential()
                + "&kf_account=" + kfAccount;
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(file.getName(), file)
        };
        return factory.createResponse(post(url, params));
    }

    // 获取所有客服账号
    @Override public ResponseKFAccountCollection listKFAccount() throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/customservice/getkflist"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
        };
        return factory.createResponseKFAccountCollection(post(url, params));
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

    // 上传图文消息素材
    @Override public ResponseUploadNews uploadNews(Map<String, Object> news) throws IOException {
        String url = conf.getMediaBaseURL() + "/cgi-bin/media/uploadnews"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(news))
        };
        return factory.createResponseUploadNews(post(url, params));
    }

    // 根据分组进行群发
    @Override public ResponseMassMessage massSendAll(Map<String, Object> msg) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/message/mass/sendall"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(msg))
        };
        return factory.createResponseMassMessage(post(url, params));
    }

    // 根据OpenID列表群发
    @Override public ResponseMassMessage massSend(Map<String, Object> msg) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/message/mass/send"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(msg))
        };
        return factory.createResponseMassMessage(post(url, params));
    }

    // 删除群发
    @Override public Response massDelete(Map<String, Object> msg) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/message/mass/delete"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(msg))
        };
        return factory.createResponse(post(url, params));
    }

    // 预览接口
    @Override public ResponseMassMessage massPreview(Map<String, Object> msg) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/message/mass/preview"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(msg))
        };
        return factory.createResponseMassMessage(post(url, params));
    }

    // 查询群发消息发送状态
    @Override public ResponseMassMessage massGet(Map<String, Object> msg) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/message/mass/get"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(msg))
        };
        return factory.createResponseMassMessage(post(url, params));
    }

    // 设置所属行业
    @Override public Response setIndustry(Map<String, Object> industry) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/template/api_set_industry"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(industry))
        };
        return factory.createResponse(post(url, params));
    }

    // 创建分组
    @Override public ResponseGroup createGroup(Map<String, Object> group) throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/create"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponseGroup(post(url, params));
    }

    // 查询所有分组
    @Override public ResponseGroupCollection listGroup() throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/get";
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("access_token", accessToken.getCredential())
        };
        return factory.createResponseGroupCollection(get(url, params));
    }

    // 查询用户所在分组
    @Override public ResponseGroup listGroup(Map<String, Object> user) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/getid"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(user))
        };
        return factory.createResponseGroup(post(url, params));
    }

    // 修改分组名
    @Override public Response updateGroup(Map<String, Object> group) throws IOException{
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/update"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponse(post(url, params));
    }

    // 移动用户分组
    @Override public Response moveGroup(Map<String, Object> group) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/members/update"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponse(post(url, params));
    }

    // 批量移动用户分组
    @Override public Response batchMoveGroup(Map<String, Object> group) throws IOException {
        String url = conf.getRestBaseURL() + "/cgi-bin/groups/members/batchupdate"
                + "?access_token=" + accessToken.getCredential();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponse(post(url, params));
    }
}
