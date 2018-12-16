package com.example.jiseo.retrofit;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {
    //public static final String API_URL = "http://jsonplaceholder.typicode.com/";

    public static final String API_URL =  "http://52.194.187.201:13001/api/";
   /*
    @GET("contents/0/index/0")
    Call<ResponseBody>getComment(@Query("id") int id);
   */
   @GET("contents/0/index/0")
    Call<DataObject> getMovie(
            @QueryMap Map<String, String> option
    );


    /*
    @GET("sample")
    public void login(
            @Query("title") String email,
            @Query("image") String password,
            Callback<DataObject> callback);
    */



}
