package com.example.javier.gamenews.Actividades.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.gamenews.Actividades.News;
import com.example.javier.gamenews.Actividades.adapters.RVadapter;
import com.example.javier.gamenews.R;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<News> lista;


    public NewsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);
        RVadapter recyclerViewAdapter = new RVadapter(getContext(), lista);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lista = new ArrayList<>();
        lista.add(new News("imagen","TituloNoticia1","SubNoticia1",false,1));
        lista.add(new News("imagen","TituloNoticia2","SubNoticia2",false,2));
        lista.add(new News("imagen","TituloNoticia3","SubNoticia3",false,3));
        lista.add(new News("imagen","TituloNoticia4","SubNoticia4",false,4));
        lista.add(new News("imagen","TituloNoticia5","SubNoticia5",false,5));
        lista.add(new News("imagen","TituloNoticia6","SubNoticia6",false,6));
        lista.add(new News("imagen","TituloNoticia7","SubNoticia7",false,7));
        lista.add(new News("imagen","TituloNoticia8","SubNoticia8",false,8));
        lista.add(new News("imagen","TituloNoticia9","SubNoticia9",false,9));
        lista.add(new News("imagen","TituloNoticia10","SubNoticia10",false,10));
    }
}
