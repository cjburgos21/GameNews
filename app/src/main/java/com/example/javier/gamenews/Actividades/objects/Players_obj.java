package com.example.javier.gamenews.Actividades.objects;

public class Players_obj {

    private String avatar;
    private String _id;
    private String name;
    private String biografia;
    private String game;
    private int __v;

    public  Players_obj(String avatar, String name, String biografia, String game, String _id, int __v){
        this.avatar = avatar;
        this._id = _id;
        this.name = name;
        this. biografia = biografia;
        this.game = game;
        this.__v = __v;
    }

    //Creando setters y getters

    public String getAvatar(){
        return avatar;
    }

    public String getName(){
        return name;
    }

    public String getBiografia(){
        return biografia;
    }

    public String getGame(){
        return game;
    }

    public String get_id(){
        return _id;
    }

    public int get__v(){
        return __v;
    }

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

    public void set_id(String _id){
        this._id = _id;
    }

    public void set__v(int __v){
        this.__v = __v;
    }
    
}
