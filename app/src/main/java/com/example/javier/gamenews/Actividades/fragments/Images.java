package com.example.javier.gamenews.Actividades.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.javier.gamenews.Actividades.News;
import com.example.javier.gamenews.Actividades.adapters.Images_adapter;
import com.example.javier.gamenews.Actividades.adapters.RVadapter;
import com.example.javier.gamenews.Actividades.conexion;
import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.javier.gamenews.Actividades.Vistas_iniciales.Login.token;
import static com.example.javier.gamenews.Actividades.fragments.NewsFragment.nuovalista;


public class Images extends Fragment {
    private static String datos;
    private Retrofit retrofit;
    private String url;
    private conexion conexion1;
    RecyclerView recyclerView;
    private List<News_obj> imagelist2;
    private List<News_obj> img_listfinal;
    private List<News_obj> extra = null;
    private Call<List<News_obj>> llama;
    View view;
    RecyclerView img_recycler;
    String title;
    String body;
    String game;
    String coverImage;
    String description;
    String created_date;

    public Images(){

    }

    public static Images Instance(String value){
        Images images = new Images();
        datos = value;
        return images;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);
        loadImages();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadImages(){
        img_listfinal = new ArrayList<>();

         url = "http://gamenewsuca.herokuapp.com/";
         retrofit = null;
         if(retrofit == null){
             retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                     .build();
         }

         conexion1 = retrofit.create(conexion.class);
         llama = conexion1.newsrequest("Bearer "+token);
         llama.enqueue(new Callback<List<News_obj>>() {
             @Override
             public void onResponse(Call<List<News_obj>> call, Response<List<News_obj>> response) {

                 extra = response.body();



                 for (int i = 0; i < extra.size(); i++) {


                         if (extra.get(i).getTitle() == null) {
                             title = "Noticia sin titulo";
                         } else {
                             title = extra.get(i).getTitle();
                         }

                         if (extra.get(i).getBody() == null) {
                             body = "Noticia sin contenido";
                         } else {
                             body = extra.get(i).getBody();
                         }

                         if (extra.get(i).getGame() == null) {
                             game = "Noticia sin juego";
                         } else {
                             game = extra.get(i).getGame();
                         }

                         if (extra.get(i).getCoverImage() == null) {
                             coverImage = "Noticia sin imagen";
                         } else {
                             coverImage = extra.get(i).getCoverImage();
                         }

                         if (extra.get(i).getDescription() == null) {
                             description = "Noticia sin descripcion";
                         } else {
                             description = extra.get(i).getDescription();
                         }

                         if (extra.get(i).getCreated_date() == null) {
                             created_date = "Noticia sin fecha";
                         } else {
                             created_date = extra.get(i).getCreated_date();
                         }

                         img_listfinal.add(new News_obj(extra.get(i).get_id()
                                 , title
                                 , body
                                 , game
                                 , coverImage
                                 , description
                                 , created_date
                                 , extra.get(i).get__v()));


                 }
                     img_recycler =  view.findViewById(R.id.recycler1);
                     img_recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
                     img_recycler.setHasFixedSize(true);
                     Images_adapter adapter = new Images_adapter(img_listfinal,getContext());
                     img_recycler.setAdapter(adapter);
             }

             @Override
             public void onFailure(Call<List<News_obj>> call, Throwable t) {

             }
         });

    }


    }

