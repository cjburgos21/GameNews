package com.example.javier.gamenews.Actividades;

public class News_obj {

    private String _id;
    private String title;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;
    private int __v;

    public News_obj(String _id, String title, String body, String game, String coverImage, String description, String created_date, int __v){
        this._id = _id;
        this.title = title;
        this.body = body;
        this.game = game;
        this.coverImage = coverImage;
        this.description = description;
        this.created_date = created_date;
        this.__v = __v;

    }

    //setters y getters


    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getGame(){
        return game;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getDescription(){
        return description;
    }

    public String getCreated_date(){
        return created_date;
    }

    public int get__v(){
        return __v;
    }


    public void set_id(String _id){
        this._id = _id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body){
        this.body = body;
    }

    public void setGame(String game){
        this.game = game;
    }

    public void setCoverImage(String coverImage){
        this.coverImage = coverImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_date(String created_date){
        this.created_date = created_date;
    }

    public void set__v(int __v){
        this.__v = __v;
    }
}

