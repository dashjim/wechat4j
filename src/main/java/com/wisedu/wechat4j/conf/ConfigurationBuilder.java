package com.wisedu.wechat4j.conf;

public final class ConfigurationBuilder {
    private ConfigurationBase conf = new PropertyConfiguration();

    public ConfigurationBuilder setDebugEnabled(boolean debugEnabled) {
        checkNotBuilt();
        conf.setDebugEnabled(debugEnabled);
        return this;
    }

    public ConfigurationBuilder setLoggerFactory(String loggerFactory){
        checkNotBuilt();
        conf.setLoggerFactory(loggerFactory);
        return this;
    }

    public ConfigurationBuilder setOAuthAppId(String oauthAppId){
        checkNotBuilt();
        conf.setOAuthAppId(oauthAppId);
        return this;
    }

    public ConfigurationBuilder setOAuthAppSecret(String oauthAppSecret){
        checkNotBuilt();
        conf.setOAuthAppSecret(oauthAppSecret);
        return this;
    }

    public ConfigurationBuilder setOAuthAppCredential(String oauthAppCredential){
        checkNotBuilt();
        conf.setOAuthAppCredential(oauthAppCredential);
        return this;
    }

    public ConfigurationBuilder setGZIPEnabled(boolean gzipEnabled){
        checkNotBuilt();
        conf.setGZIPEnabled(gzipEnabled);
        return this;
    }

    public ConfigurationBuilder setHttpProxyHost(String httpProxyHost) {
        checkNotBuilt();
        conf.setHttpProxyHost(httpProxyHost);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPort(int httpProxyPort) {
        checkNotBuilt();
        conf.setHttpProxyPort(httpProxyPort);
        return this;
    }

    public ConfigurationBuilder setHttpProxyUser(String httpProxyUser) {
        checkNotBuilt();
        conf.setHttpProxyUser(httpProxyUser);
        return this;
    }

    public ConfigurationBuilder setHttpProxyPassword(String httpProxyPassword) {
        checkNotBuilt();
        conf.setHttpProxyPassword(httpProxyPassword);
        return this;
    }

    public ConfigurationBuilder setHttpRetryCount(int httpRetryCount){
        checkNotBuilt();
        conf.setHttpRetryCount(httpRetryCount);
        return this;
    }

    public ConfigurationBuilder setHttpReadTimeout(int httpReadTimeout){
        checkNotBuilt();
        conf.setHttpReadTimeout(httpReadTimeout);
        return this;
    }

    public ConfigurationBuilder setHttpConnectionTimeout(int httpConnectionTimeout){
        checkNotBuilt();
        conf.setHttpConnectionTimeout(httpConnectionTimeout);
        return this;
    }

    public ConfigurationBuilder setHttpRetryIntervalSeconds(int httpRetryIntervalSeconds){
        checkNotBuilt();
        conf.setHttpRetryIntervalSeconds(httpRetryIntervalSeconds);
        return this;
    }

    public ConfigurationBuilder setRestBaseURL(String restBaseURL){
        checkNotBuilt();
        conf.setRestBaseURL(restBaseURL);
        return this;
    }

    public ConfigurationBuilder setMPBaseURL(String mpBaseURL) {
        checkNotBuilt();
        conf.setMPBaseURL(mpBaseURL);
        return this;
    }

    public ConfigurationBuilder setMediaBaseURL(String mediaBaseURL){
        checkNotBuilt();
        conf.setMediaBaseURL(mediaBaseURL);
        return this;
    }

    public ConfigurationBuilder setOAuth2CodeURL(String oauth2CodeURL) {
        checkNotBuilt();
        conf.setOAuth2CodeURL(oauth2CodeURL);
        return this;
    }

    private void checkNotBuilt(){
        if (conf == null){
            throw new IllegalStateException("Cannot use this builder any longer, build() has already been called");
        }
    }

    public Configuration build(){
        checkNotBuilt();
        try {
            return conf;
        } finally {
            conf = null;
        }
    }
}
