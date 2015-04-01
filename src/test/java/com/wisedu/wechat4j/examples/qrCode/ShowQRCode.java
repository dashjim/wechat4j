package com.wisedu.wechat4j.examples.qrCode;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.io.File;

public class ShowQRCode {
    private static final String dst = ShowQRCode.class.getResource("/").getPath() + "qrcode.png";
    private static final String ticket = "gQEr8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xLzhFUGI5QVhtelJhMHhqQS0ybXVtAAIE8GcaVQMEAAAAAA==";

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.showQRCode(ticket, new File(dst));
        if (response.getErrCode()==0 && new File(dst).exists()) {
            System.out.println("Show QR Code Succeed." + response);
        }
    }
}