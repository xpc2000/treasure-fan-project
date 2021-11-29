package com.example.firstapplication.utils;

import org.json.JSONException;

public interface ResponseCallBack {
    void success(String json) throws JSONException;

    void error(String json);
}
