package com.example.javier.gamenews.Actividades.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.gamenews.Actividades.objects.Players_obj;
import com.example.javier.gamenews.R;
import com.example.javier.gamenews.Actividades.adapters.Toplayer_adapter;
import static com.example.javier.gamenews.Actividades.Vistas_iniciales.Login.token;
import com.example.javier.gamenews.Actividades.conexion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopPlayers extends Fragment {

    View view;
    private String url;
    private conexion playersconexion;
    private Retrofit retrofit2;
    private RecyclerView recyclerView;
    private Call<List<Players_obj>> llama2;
    public String name;
    public String game;
    public String biografia;
    public String avatar;
    public String __v;
    public List<Players_obj> lista3 = null;
    public List<Players_obj> listafinal;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_players,container,false);

        loadPlayers(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadPlayers(final View view3){
        url = "http://gamenewsuca.herokuapp.com/";

        if(retrofit2 == null){
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        playersconexion = retrofit2.create(conexion.class);

        llama2 = playersconexion.playersrequest("Bearer " +token);
        llama2.enqueue(new Callback<List<Players_obj>>() {
            @Override
            public void onResponse(Call<List<Players_obj>> call, Response<List<Players_obj>> response) {
                lista3 = response.body();
                listafinal = new ArrayList<>();

                for(int i=0; i<lista3.size();i++){

                    if(lista3.get(i).getAvatar() == null){
                        avatar = "Jugador sin imagen";}
                        else{
                        avatar = lista3.get(i).getAvatar();}


                        if(lista3.get(i).getName() == null){
                        name = "Jugador sin nombre";
                        }
                        else{
                        name = lista3.get(i).getName();
                        }

                        if(lista3.get(i).getBiografia() == null){
                        biografia = "Jugador sin biografia";
                        }
                        else{
                        biografia = lista3.get(i).getBiografia();
                        }

                        if(lista3.get(i).getGame() == null){
                        game = "Jugador sin juego";
                        }
                        else {
                            game = lista3.get(i).getGame();
                        }

                        listafinal.add(
                                new Players_obj(avatar
                                ,name
                                        ,biografia
                                        ,game
                                        ,lista3.get(i).get_id()
                                ,lista3.get(i).get__v()));

                }


                recyclerView = (RecyclerView) view3.findViewById(R.id.top_players_recyclerview);
                Toplayer_adapter toplayerAdapter= new Toplayer_adapter(getContext(), listafinal);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(toplayerAdapter);



            }

            @Override
            public void onFailure(Call<List<Players_obj>> call, Throwable t) {

            }
        });

    }


}

