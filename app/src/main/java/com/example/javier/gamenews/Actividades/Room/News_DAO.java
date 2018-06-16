package com.example.javier.gamenews.Actividades.Room;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

public interface News_DAO {
    @Insert
    public void insert(News_DB... news_dbs);

    @Update
    public void update(News_DB... news_dbs);

    @Delete
    public void delete(News_DB... news_dbs);

}

