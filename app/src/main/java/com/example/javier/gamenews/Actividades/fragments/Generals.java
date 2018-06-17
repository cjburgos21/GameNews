package com.example.javier.gamenews.Actividades.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.gamenews.Actividades.adapters.Generals_adapter;
import com.example.javier.gamenews.Actividades.adapters.Images_adapter;
import com.example.javier.gamenews.Actividades.adapters.RVadapter;
import com.example.javier.gamenews.Actividades.adapters.Toplayer_adapter;
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

public class Generals extends Fragment {

    private String url;
    private conexion generalsconexion;
    private Retrofit retrofit3;
    private RecyclerView recyclerView2;
    private Call<List<News_obj>> llama3;
    public String title;
    public String body;
    public String game;
    public String coverImage;
    public String description;
    public String created_date;
    private int __v;
    public List<News_obj> lista4 = null;
    public List<News_obj> listafinal2;
    public List<News_obj> filtrada2;
    String aux4;


    View view;


    public Generals() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_generals, container, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}