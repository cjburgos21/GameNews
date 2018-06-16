package com.example.javier.gamenews.Actividades.Room;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "news")
public class News_DB {
    private String title;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;
    private int __v;

    @PrimaryKey
    @NonNull
    private int _id;

    //No se utiliza constructr por el uso de @Entity


    //Creando setters y getters para atributos restantes
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getBody(){
        return body;
    }


    public void setGame(String game){
        this.game = game;
    }

    public String getGame(){
        return game;
    }

    public void setCoverImage(String coverImage){
        this.coverImage = coverImage;
    }

    public String getCoverImage(){
        return coverImage;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCreated_date(String created_date){
        this.created_date = created_date;
    }

    public String getCreated_date(){
        return created_date;
    }

    public void set__v(int __v){
        this.__v = __v;
    }

    public int get__v(){
        return __v;
    }

    @NonNull
    public int get_id(){
        return _id;
    }

    public void set_id(int _id){
        this._id = _id;
    }

}
