package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.http.HttpResponse;

import java.io.File;
import java.io.IOException;

public class ObjectFactory {
    public Response createResponse(HttpResponse response) throws IOException {
        return new ResponseJSONImpl(response);
    }

    public AccessToken createAccessToken(String credential, Long expiresIn) {
        return new AccessTokenJSONImpl(credential, expiresIn);
    }

    public ResponseAccessToken createResponseAccessToken(HttpResponse response) {
        return new ResponseAccessTokenJSONImpl(response);
    }

    public ResponseMedia createResponseMedia(HttpResponse response) {
        return new ResponseMediaJSONImpl(response);
    }

    public ResponseFile createResponseFile(HttpResponse response, File file) throws IOException{
        return new ResponseFileJSONImpl(response, file);
    }

    public ResponseGroup createResponseGroup(HttpResponse response) {
        return new ResponseGroupJSONImpl(response);
    }

    public ResponseGroupCollection createResponseGroupCollection(HttpResponse response) {
        return new ResponseGroupCollectionJSONImpl(response);
    }

    public ResponseKFAccountCollection createResponseKFAccountCollection(HttpResponse response) {
        return new ResponseKFAccountCollectionJSONImpl(response);
    }

    public ResponseUploadNews createResponseUploadNews(HttpResponse response) {
        return new ResponseUploadNewsJSONImpl(response);
    }

    public ResponseMessage createResponseMessage(HttpResponse response) {
        return new ResponseMessageJSONImpl(response);
    }

    public ResponseTemplate createResponseTemplate(HttpResponse response) {
        return new ResponseTemplateJSONImpl(response);
    }

    public ResponseUser createResponseUser(HttpResponse response) {
        return new ResponseUserJSONImpl(response);
    }

    public ResponseUserCollection createResponseUserCollection(HttpResponse response) {
        return new ResponseUserCollectionJSONImpl(response);
    }

    public ResponseOAuth2AccessToken createResponseOAuth2AccessToken(HttpResponse response) {
        return new ResponseOAuth2AccessTokenJSONImpl(response);
    }

    public ResponseMenu createResponseMenu(HttpResponse response) {
        return new ResponseMenuJSONImpl(response);
    }

    public ResponseTicket createResponseTicket(HttpResponse response) {
        return new ResponseTicketJSONImpl(response);
    }
}
