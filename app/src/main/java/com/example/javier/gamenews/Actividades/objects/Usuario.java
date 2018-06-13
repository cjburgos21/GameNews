package com.example.javier.gamenews.Actividades.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("token")
    @Expose

    private String token;
    public Usuario(String token) {this.token = token;}
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

}
