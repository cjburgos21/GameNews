package com.example.javier.gamenews.Actividades.Room;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

public interface Players__DAO {

    @Insert
    public void insert(Players_DB... players_dbs);

    @Update
    public void update(Players_DB... players_dbs);


    @Delete
    public void delete(Players_DB players_db);

    @Query("SELECT * FROM players_db")
    public List<Players_DB> getPlayers();

    @Query("SELECT * FROM players_db WHERE game = :lol")
    public Players_DB getPlayersWhitId(String game);
}
