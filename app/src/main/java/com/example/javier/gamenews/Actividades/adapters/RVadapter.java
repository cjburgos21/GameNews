package com.example.javier.gamenews.Actividades.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.gamenews.Actividades.fragments.Images;
import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RVadapter extends RecyclerView.Adapter<RVadapter.MyViewHolder>{
        Context context;
        List<News_obj> NewsList;

        public RVadapter(Context context, List<News_obj> NewList){
            this.context = context;
            this.NewsList = NewList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View vista;
            vista = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(vista);
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nuevotitulo.setText(NewsList.get(position).getTitle());
        holder.nuevosub.setText(NewsList.get(position).getDescription());

        if(NewsList.get(position).getCoverImage() != "Noticia sin imagen"){
            Picasso.with(context).load(NewsList.get(position).getCoverImage()).into(holder.nuevaimagen);


        }

    }

        @Override
        public int getItemCount() {

            return NewsList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            private ImageView nuevaimagen;
            private TextView nuevotitulo;
            private TextView nuevosub;

        public MyViewHolder(View itemView) {
            super(itemView);

            nuevotitulo = (TextView) itemView.findViewById(R.id.titulo);
            nuevosub = (TextView) itemView.findViewById(R.id.subtitulo);
            nuevaimagen = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }

}

