package com.wisedu.wechat4j.api;

public interface Wechat extends
        BaseService,
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
    // 设置Access Token
    void setAccessToken(String credential, Long expiresIn);
}
