package com.example.javier.gamenews.Actividades.Room;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Players_DB {

    private String avatar;
    private String name;
    private String biografia;
    private String game;
    private int __v;

    @PrimaryKey
    @NonNull
    private int _id;


    //No se utiliza constructor por el uso de @Entity


    //Creando setters y getters
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBiografia(String biografia){
        this.biografia = biografia;
    }

    public void setGame(String game){
        this.game = game;
    }

    public void set__v(int __v){
        this.__v = __v;
    }

    public String getAvatar(){
        return avatar;
    }

    public String getName(){
        return name;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getGame(){
        return game;
    }

    public int get__v(){
        return __v;
    }


    @NonNull
    public int get_id(){
        return _id;
    }

    public void set_id(){
        this._id = _id;
    }

}
