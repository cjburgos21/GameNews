package com.example.javier.gamenews.Actividades.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javier.gamenews.Actividades.News;
import com.example.javier.gamenews.Actividades.News_obj;
import com.example.javier.gamenews.R;

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

        final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (position == 0 || position%3==0) {
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(true);
            holder.itemView.setLayoutParams(sglp);
        }

    }

        @Override
        public int getItemCount() {
        return NewsList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nuevotitulo;
        private TextView nuevosub;

        public MyViewHolder(View itemView) {
            super(itemView);

            nuevotitulo = (TextView) itemView.findViewById(R.id.titulo);
            nuevosub = (TextView) itemView.findViewById(R.id.subtitulo);

        }
    }

}

