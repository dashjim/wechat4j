package com.wisedu.wechat4jv2.conf;

public final class ConfigurationBuilder {
    private ConfigurationBase conf = new PropertyConfiguration();

    public ConfigurationBuilder setGZIPEnabled(boolean gzipEnabled){
        checkNotBuilt();
        conf.setGZIPEnabled(gzipEnabled);
        return this;
    }

    public ConfigurationBuilder setLoggerFactory(String loggerFactory){
        checkNotBuilt();
        conf.setLoggerFactory(loggerFactory);
        return this;
    }

    public ConfigurationBuilder setRestBaseURL(String restBaseURL){
        checkNotBuilt();
        conf.setRestBaseURL(restBaseURL);
        return this;
    }

    public ConfigurationBuilder setAuthToken(String authToken){
        checkNotBuilt();
        conf.setAuthToken(authToken);
        return this;
    }

    public ConfigurationBuilder setAuthAppId(String authAppId){
        checkNotBuilt();
        conf.setAuthAppID(authAppId);
        return this;
    }

    public ConfigurationBuilder setAuthAppSecret(String authAppSecret){
        checkNotBuilt();
        conf.setAuthAppSecret(authAppSecret);
        return this;
    }

    public ConfigurationBuilder setAuthAccessToken(String authAccessToken) {
        checkNotBuilt();
        conf.setAuthAccessToken(authAccessToken);
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

    public ConfigurationBuilder setHttpMaxTotalConnections(int httpMaxTotalConnections){
        checkNotBuilt();
        conf.setHttpMaxTotalConnections(httpMaxTotalConnections);
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
