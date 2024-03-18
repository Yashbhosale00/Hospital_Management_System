//package com.example.i_hospital.retrofitinstance;
//
//import retrofit2.Retrofit;
//
//
//public class RetrofitClient {
//    private static final String BASE_URL = "https://doctorapp.masystechsolution.com/";
//
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient() {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}
