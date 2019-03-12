package com.example.core.application;

import android.app.Application;

import com.example.core.network.INewsSevice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public abstract class BaseApplication extends Application {
    private static INewsSevice apiService;
    private Retrofit retrofit;
    private static BaseApplication instance;
    int cacheSize = 7 * 1024 * 1024;
    private OkHttpClient okHttpClient;

    public INewsSevice getApi() {
        return apiService;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setupRetrofitAndOkHttp();
        instance = this;
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = initFactory();


    }

    private void setupRetrofitAndOkHttp() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File httpCacheDirectory = new File(getCacheDir(), "offlineCache");

        //7 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(provideCacheInterceptor())
                .addInterceptor(provideOfflineCacheInterceptor())
                .build();

    }

    private Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response originalResponse = chain.proceed(request);
                String cacheControl = originalResponse.header("Cache-Control");

                if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                        cacheControl.contains("must-revalidate") || cacheControl.contains("max-stale=0")) {
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=" + 5000)
                            .build();
                } else {
                    return originalResponse;
                }
            }
        };
    }

    private Interceptor provideOfflineCacheInterceptor() {

        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (Exception e) {


                    CacheControl cacheControl = new CacheControl.Builder()
                            .onlyIfCached()
                            .maxStale(60, TimeUnit.DAYS)
                            .build();

                    Request offlineRequest = chain.request().newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached")
                            .cacheControl(cacheControl)
                            .build();
                    return chain.proceed(offlineRequest);
                }
            }
        };
    }


    public abstract String getBaseUrl();

    public Retrofit getService() {
        return retrofit;
    }

    public static BaseApplication getInstance(){
        return instance;
    }
    public abstract INewsSevice initFactory();


}
