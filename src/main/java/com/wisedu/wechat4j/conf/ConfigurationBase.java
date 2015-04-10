package com.wisedu.wechat4j.conf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class ConfigurationBase implements Configuration, Serializable {
    private static final long serialVersionUID = -6692513626308299468L;
    private boolean debugEnabled;

    private String loggerFactory;

    private String oauthAppId;
    private String oauthAppSecret;
    private String oauthAppCredential;

    private boolean gzipEnabled;

    private String httpProxyHost;
    private int httpProxyPort;
    private String httpProxyUser;
    private String httpProxyPassword;

    private int httpRetryCount;
    private int httpReadTimeout;
    private int httpConnectionTimeout;
    private int httpRetryIntervalSeconds;

    private Map<String, String> requestHeaders;
    private String restBaseURL = "https://api.weixin.qq.com";
    private String mpBaseURL = "https://mp.weixin.qq.com";
    private String mediaBaseURL = "http://file.api.weixin.qq.com";
    private String oauth2CodeURL = "https://open.weixin.qq.com";

    protected ConfigurationBase(){
        setDebugEnabled(false);
        setLoggerFactory(null);

        setOAuthAppId(null);
        setOAuthAppSecret(null);

        setGZIPEnabled(true);

        setHttpProxyHost(null);
        setHttpProxyPort(-1);
        setHttpProxyUser(null);
        setHttpProxyPassword(null);

        setHttpRetryCount(0);
        setHttpReadTimeout(120000);
        setHttpConnectionTimeout(20000);
        setHttpRetryIntervalSeconds(5000);
    }

    @Override public final boolean isDebugEnabled() {
        return debugEnabled;
    }

    protected final void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public final Map<String, String> getRequestHeaders(){
        return requestHeaders;
    }

    @Override public final String getLoggerFactory(){
        return loggerFactory;
    }

    protected final void setLoggerFactory(String loggerFactory){
        this.loggerFactory = loggerFactory;
    }

    @Override public final String getOAuthAppId(){
        return oauthAppId;
    }

    protected final void setOAuthAppId(String oauthAppId){
        this.oauthAppId = oauthAppId;
    }

    @Override public final String getOAuthAppSecret(){
        return oauthAppSecret;
    }

    protected final void setOAuthAppSecret(String oauthAppSecret){
        this.oauthAppSecret = oauthAppSecret;
    }

    @Override public final String getOAuthAppCredential(){
        return oauthAppCredential;
    }

    protected final void setOAuthAppCredential(String oauthAppCredential){
        this.oauthAppCredential = oauthAppCredential;
    }

    @Override public final boolean isGZIPEnabled(){
        return gzipEnabled;
    }

    protected final void setGZIPEnabled(boolean gzipEnabled){
        this.gzipEnabled = gzipEnabled;
        initRequestHeaders();
    }

    private void initRequestHeaders(){
        requestHeaders = new HashMap<String, String>();
        if (isGZIPEnabled()){
            requestHeaders.put("Accept-Encoding", "gzip");
        }
    }

    @Override public final String getHttpProxyHost() {
        return httpProxyHost;
    }

    protected final void setHttpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    @Override public final int getHttpProxyPort() {
        return httpProxyPort;
    }

    protected final void setHttpProxyPort(int httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }

    @Override public final String getHttpProxyUser() {
        return httpProxyUser;
    }

    protected final void setHttpProxyUser(String httpProxyUser) {
        this.httpProxyUser = httpProxyUser;
    }

    @Override public String getHttpProxyPassword() {
        return httpProxyPassword;
    }

    protected final void setHttpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
    }

    @Override public final int getHttpRetryCount(){
        return httpRetryCount;
    }

    protected final void setHttpRetryCount(int httpRetryCount){
        this.httpRetryCount = httpRetryCount;
    }

    @Override public final int getHttpReadTimeout(){
        return httpReadTimeout;
    }

    protected final void setHttpReadTimeout(int httpReadTimeout){
        this.httpReadTimeout = httpReadTimeout;
    }

    @Override public final int getHttpConnectionTimeout(){
        return httpConnectionTimeout;
    }

    protected final void setHttpConnectionTimeout(int httpConnectionTimeout){
        this.httpConnectionTimeout = httpConnectionTimeout;
    }

    @Override public final int getHttpRetryIntervalSeconds(){
        return httpRetryIntervalSeconds;
    }

    protected final void setHttpRetryIntervalSeconds(int httpRetryIntervalSeconds){
        this.httpRetryIntervalSeconds = httpRetryIntervalSeconds;
    }

    @Override public String getRestBaseURL() {
        return restBaseURL;
    }

    protected final void setRestBaseURL(String restBaseURL) {
        this.restBaseURL = restBaseURL;
    }

    @Override public String getMPBaseURL() {
        return mpBaseURL;
    }

    protected final void setMPBaseURL(String mpBaseURL) {
        this.mpBaseURL = mpBaseURL;
    }

    @Override public String getMediaBaseURL() {
        return mediaBaseURL;
    }

    protected final void setMediaBaseURL(String mediaBaseURL) {
        this.mediaBaseURL = mediaBaseURL;
    }

    @Override public String getOAuth2CodeURL() {
        return oauth2CodeURL;
    }

    protected final void setOAuth2CodeURL(String oauth2CodeURL) {
        this.oauth2CodeURL = oauth2CodeURL;
    }
}