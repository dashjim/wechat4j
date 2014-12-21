package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class MenuCollectionJSONImpl implements MenuCollection, Serializable {

    private Button[] buttons;
    private Response response;

    MenuCollectionJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    MenuCollectionJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("menu")) {
            JSONObject menu = jsonObject.getJSONObject("menu");
            if (!jsonObject.isNull("button")) {
                JSONArray array = menu.getJSONArray("button");

                int size = array.length();
                this.buttons = new Button[size];
                for (int i=0; i<size; i++) {
                    buttons[i] = new ButtonJSONImpl(array.getJSONObject(i));
                }
            }
        }
    }

    @Override public Button[] getButtons() {
        return buttons;
    }

    @Override public Response getResponse() {
        return response;
    }

    @Override public String toString() {
        return this.response.toString();
    }
}
