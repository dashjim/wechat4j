package com.wisedu.wechat4j.entity;

import com.wisedu.wechat4j.http.HttpResponse;
import com.wisedu.wechat4j.internal.json.JSONObject;

import java.io.Serializable;

final class MediaJSONImpl implements Media, Serializable {
    private static final long serialVersionUID = 444900494832942094L;

    private String type;
    private String mediaId;
    private Long createTime;

    JSONObject object;

    MediaJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    MediaJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("type")) {
            this.type = jsonObject.getString("type");
        }
        if (!jsonObject.isNull("media_id")) {
            this.mediaId = jsonObject.getString("media_id");
        }
        if (!jsonObject.isNull("created_at")) {
            this.createTime = jsonObject.getLong("created_at");
        }
    }

    @Override public String getType() {
        return type;
    }

    @Override public String getMediaId() {
        return mediaId;
    }

    @Override public Long getCreatedTime() {
        return createTime;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;

        MediaJSONImpl that = (MediaJSONImpl)o;

        if (createTime!=null? !createTime.equals(that.createTime): that.createTime!=null) return false;
        if (mediaId!=null? !mediaId.equals(that.mediaId): that.mediaId!=null) return false;
        if (type!=null? !type.equals(that.type): that.type!=null) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = 0;
        result = 31*result + (type!=null? type.hashCode(): 0);
        result = 31*result + (mediaId!=null? mediaId.hashCode(): 0);
        result = 31*result + (createTime!=null? createTime.hashCode(): 0);
        return result;
    }

    @Override public String toString() {
        return object.toString();
    }
}