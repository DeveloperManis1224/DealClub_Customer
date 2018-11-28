package com.app.android.deal.dealclub.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL ="http://192.168.1.112:8080/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            //The logging interceptor will be added to the http client
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);


         retrofit = new Retrofit.Builder().client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();


        }
        return retrofit;
    }
}