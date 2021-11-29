package com.example.firstapplication.utils;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;

import java.io.IOException;

public class OkHttpUtils {
    private static final String TAG = "OkHttpUtils";
    //handler主要用于异步请求数据之后更新UI
    private static Handler handler = new Handler();
    public static void getAsync(String url, final ResponseCallBack responseCallBack) {
        OkHttpClient client = new OkHttpClient();
        Log.i(TAG, "请求地址===》" + url);
        Request request = new Request
                .Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException error) {
                Log.e(TAG,"响应失败===》"+error.getMessage());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        responseCallBack.error("获取失败");
                    }
                });
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String respBody=response.body().string();
                Log.i(TAG,"响应成功===》"+respBody);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            responseCallBack.success(respBody);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void postAsync(String url,  final ResponseCallBack responseCallBack, Object obj){
        Gson gson = new Gson();
        String json=gson.toJson(obj);
        Log.i(TAG, "请求地址===》" + url);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder().url(url)
                .post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException error) {
                Log.e(TAG,"响应失败===》"+error.getMessage());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        responseCallBack.error("获取失败");
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String respBody=response.body().string();
                Log.i(TAG,"响应成功===》"+respBody);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            responseCallBack.success(respBody);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void delteAsync(String url, final ResponseCallBack responseCallBack){
        OkHttpClient client = new OkHttpClient();
        Log.i(TAG, "请求地址===》" + url);
        Request request = new Request
                .Builder()
                .url(url)
                .delete()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException error) {
                Log.e(TAG,"响应失败===》"+error.getMessage());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        responseCallBack.error("获取失败");
                    }
                });
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String respBody=response.body().string();
                Log.i(TAG,"响应成功===》"+respBody);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            responseCallBack.success(respBody);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

}

