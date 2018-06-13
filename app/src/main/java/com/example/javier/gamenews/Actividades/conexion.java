package com.example.javier.gamenews.Actividades;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import com.example.javier.gamenews.Actividades.News_obj;

import java.util.List;

public interface conexion {

    @FormUrlEncoded
    @POST("login")
    Call<Usuario> logrequest(@Field("user") String username, @Field("password")String password);


    @GET("news")
    Call<List<News_obj>> newsrequest(@Header("Authorization") String token);



}
