package com.example.javier.gamenews.Actividades;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.Actividades.objects.Players_obj;
import com.example.javier.gamenews.Actividades.objects.Usuario;

import java.util.List;

public interface conexion {

    @FormUrlEncoded
    @POST("login")
    Call<Usuario> logrequest(@Field("user") String username, @Field("password")String password);


    @GET("news")
    Call<List<News_obj>> newsrequest(@Header("Authorization") String token);

    @GET("players")
    Call<List<Players_obj>> playersrequest(@Header("Authorization") String token);



}
