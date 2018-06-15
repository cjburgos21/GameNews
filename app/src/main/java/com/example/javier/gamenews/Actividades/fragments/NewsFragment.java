package com.example.javier.gamenews.Actividades.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.Actividades.adapters.RVadapter;
import com.example.javier.gamenews.R;
import com.example.javier.gamenews.Actividades.conexion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.javier.gamenews.Actividades.Vistas_iniciales.Login.token;


public class NewsFragment extends Fragment {

    View view;
    private String url;
    private conexion newsconexion;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private Call<List<News_obj>> llama;
    private String title;
    private List<News_obj> lista2 = null;
    private List<News_obj> nuovalista;
    private String body;
    private String game;
    private String coverImage;
    private String description;
    private String created_date;



    public NewsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);

        loadNews(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void loadNews(final View view2){
        url = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
                retrofit = new Retrofit.Builder()
                .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        newsconexion = retrofit.create(conexion.class);

        llama = newsconexion.newsrequest("Bearer " +token);
        llama.enqueue(new Callback<List<News_obj>>() {
            @Override
            public void onResponse(Call<List<News_obj>> call, Response<List<News_obj>> response) {
                lista2 = response.body();
                nuovalista = new ArrayList<>();



                for(int i=0; i<lista2.size();i++){

                    if(lista2.get(i).getTitle() == null){
                        title = "Noticia sin titulo";}
                    else{
                        title = lista2.get(i).getTitle(); }

                    if(lista2.get(i).getBody() == null){
                        body = "Noticia sin contenido";}
                    else{
                        body = lista2.get(i).getBody(); }

                    if(lista2.get(i).getGame() == null){
                        game = "Noticia sin juego";}
                    else{
                        game = lista2.get(i).getGame(); }

                    if(lista2.get(i).getCoverImage() == null){
                        coverImage = "Noticia sin imagen";}
                    else{
                        coverImage = lista2.get(i).getCoverImage(); }

                    if(lista2.get(i).getDescription() == null){
                        description = "Noticia sin descripcion";}
                    else{
                        description = lista2.get(i).getDescription(); }

                    if(lista2.get(i).getCreated_date() == null){
                        created_date = "Noticia sin fecha";}
                    else{
                        created_date = lista2.get(i).getCreated_date(); }


                    nuovalista.add(new News_obj(lista2.get(i).get_id()
                            ,title
                            ,body
                            ,game
                            ,coverImage
                            ,description
                            ,created_date
                            ,lista2.get(i).get__v()));


                }

                recyclerView = (RecyclerView) view2.findViewById(R.id.recycler1);
                RVadapter rVadapter = new RVadapter(getContext(), nuovalista);


                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position %3 == 0 ){
                            return 2;
                        }
                        else{
                            return 1;
                        }
                    }
                });

                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(rVadapter);


            }

            @Override
            public void onFailure(Call<List<News_obj>> llama, Throwable t) {

            }
        });


    }

}
