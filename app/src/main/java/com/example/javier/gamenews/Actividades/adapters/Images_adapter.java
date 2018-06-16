package com.example.javier.gamenews.Actividades.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Images_adapter extends RecyclerView.Adapter<Images_adapter.Imgs_holder>{

    List<News_obj> imgslist;
    Context context;


    public Images_adapter(List<News_obj> imgslistm, Context context){
        this.imgslist = imgslistm;
        this.context = context;
    }

    @Override
    public Imgs_holder onCreateViewHolder(ViewGroup parent, int tipo){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imgs_content, null,false);
        return new Images_adapter.Imgs_holder(view);
    }

    @Override
    public void onBindViewHolder(Imgs_holder holder, int position){
        if(imgslist.get(position).getCoverImage() !="No posee imagen"){
            Picasso.with(context).load(imgslist.get(position).getCoverImage()).into(holder.image1);
        }
    }

    @Override
    public int getItemCount(){
        return imgslist.size();
    }

    public class Imgs_holder extends RecyclerView.ViewHolder{
        ImageView image1;

        public Imgs_holder(View item){
            super(item);
            image1 = item.findViewById(R.id.img_view);
        }
    }


}
