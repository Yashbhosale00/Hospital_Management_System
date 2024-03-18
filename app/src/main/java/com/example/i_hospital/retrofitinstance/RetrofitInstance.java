package com.example.i_hospital.retrofitinstance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    static RetrofitInterface retrofitInterface;

    public static Retrofit retrofit;
    public static final String BASE_URL = "https://doctorapp.masystechsolution.com/";


    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            final OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitLoggingClient() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build();
//      jsonReader.setLenient(true);

        }
        return retrofit;
    }


//    public static RetrofitInterface getSeviceData() {
//        retrofitInterface = RetrofitInstance.getRetrofit().create(RetrofitInterface.class);
//        return retrofitInterface;
//    }
//
//    public static RetrofitInterface getSeviceDataLogging() {
//        retrofitInterface = RetrofitInstance.getRetrofitLoggingClient().create(RetrofitInterface.class);
//        return retrofitInterface;
//    }

//    private static  Retrofit uploadRetrofit;
//    private static final String BASE_URL_UPLOAD="";

//    public static  Retrofit getUploadRetrofit(){
//        OkHttpClient  okHttpClient=new OkHttpClient.Builder().build();
//
//        if (uploadRetrofit==null){
//            uploadRetrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
//                    .client(okHttpClient).build();
//        }
//        return uploadRetrofit;
//    }

}
