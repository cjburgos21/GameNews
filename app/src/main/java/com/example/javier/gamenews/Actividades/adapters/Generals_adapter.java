package com.example.javier.gamenews.Actividades.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Generals_adapter extends RecyclerView.Adapter<Generals_adapter.generals_holder>{

    Context context;
    List<News_obj> NewsList;



    public Generals_adapter(Context context, List<News_obj> NewList){
        this.context = context;
        this.NewsList = NewList;
    }

    @Override
    public generals_holder onCreateViewHolder(ViewGroup parent, int viewType){
        View vista;
        vista = LayoutInflater.from(context).inflate(R.layout.generals_content,parent,false);
        Generals_adapter.generals_holder viewHolder2 = new Generals_adapter.generals_holder(vista);
            /*viewHolder.itemNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            });*/
        return viewHolder2;
    }


    @Override
    public void onBindViewHolder(Generals_adapter.generals_holder holder, int position) {
        holder.nuevotitulo2.setText(NewsList.get(position).getTitle());
        holder.nuevosub2.setText(NewsList.get(position).getDescription());

        if(NewsList.get(position).getCoverImage() != "Noticia sin imagen"){
            Picasso.with(context).load(NewsList.get(position).getCoverImage()).into(holder.nuevaimagen2);


        }

        holder.itemNews2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Noticia añadida a favoritos",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return NewsList.size();
    }

    public static class generals_holder extends RecyclerView.ViewHolder{
        List<News_obj> NewsList;
        private ImageView nuevaimagen2;
        private TextView nuevotitulo2;
        private TextView nuevosub2;
        private Context context2;
        private CardView itemNews2;

        public generals_holder(View itemView) {
            super(itemView);
            nuevotitulo2 = (TextView) itemView.findViewById(R.id.titulo2);
            nuevosub2 = (TextView) itemView.findViewById(R.id.subtitulo2);
            nuevaimagen2 = (ImageView) itemView.findViewById(R.id.imagen2);
            itemNews2 = (CardView) itemView.findViewById(R.id.cardview2);
        }


    }



}



