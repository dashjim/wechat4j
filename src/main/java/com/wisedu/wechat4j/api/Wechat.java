package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseAccessToken;

import java.io.IOException;

public interface Wechat extends
        MediaService,
        KFAccountService,
        MassService,
        TemplateService,
        GroupService,
        UserService,
        OAuth2Service,
        MenuService,
        QRCodeService,
        ShortURLService {
    void setAccessToken(String credential, Long expiresIn);

    // 获取Access Token
    ResponseAccessToken getAccessToken() throws IOException;
}
