package com.example.se_time.mall.application;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MallApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpUtils();
    }

    private void initOkHttpUtils() {
        //保持Cookie
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
                        .addInterceptor(new LoggerInterceptor("TAG")).build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
