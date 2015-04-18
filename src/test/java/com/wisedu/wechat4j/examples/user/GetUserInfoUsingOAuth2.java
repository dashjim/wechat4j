package com.wisedu.wechat4j.examples.user;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseOAuth2AccessToken;
import com.wisedu.wechat4j.entity.ResponseUser;
import twitter4j.TwitterException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

// 获取用户列表
public class GetUserInfoUsingOAuth2 {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();

        // 进入授权页面
        String oauth2URL = wechat.generateOAuth2URL("http://wechat.ngrok.com/tShow/Wechat.do", "snsapi_userinfo", "state");
        System.out.println("Open the following URL and grant access to your account: " + oauth2URL);
        try {
            Desktop.getDesktop().browse(new URI(oauth2URL));
        } catch (UnsupportedOperationException ignore) {
        } catch (IOException ignore) {
        } catch (URISyntaxException e) {
            throw new AssertionError(e);
        }

        // 获取Code&换取Access Token
        ResponseOAuth2AccessToken accessToken = null;
        System.out.print("Enter the Code(if available) and hit enter after you granted access.[Code]:");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (code.length() > 0) {
            accessToken  = wechat.getOAuth2AccessToken(code);
        }
        if (accessToken.getResponse().getErrCode() == 0) {
            System.out.println("Get OAuth2 Access Token Succeed." + accessToken);
        } else {
            System.err.println("Get OAuth2 Access Token Failed.." + accessToken);
        }

        // 拉取用户信息
        ResponseUser user = wechat.getOAuth2UserInfo(accessToken.getAccessToken(), accessToken.getOpenId(), "zh_CN");
        if (user.getResponse().getErrCode() == 0) {
            System.out.println("Get User Info Succeed." + accessToken);
        } else {
            System.err.println("Get User Info Token Failed." + accessToken);
        }
    }
}