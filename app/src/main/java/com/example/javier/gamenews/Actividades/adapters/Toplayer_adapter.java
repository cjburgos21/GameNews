package com.example.javier.gamenews.Actividades.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import com.example.javier.gamenews.Actividades.fragments.TopPlayers;
import com.example.javier.gamenews.Actividades.objects.Players_obj;
import com.example.javier.gamenews.R;
import com.squareup.picasso.Picasso;


public class Toplayer_adapter extends RecyclerView.Adapter<Toplayer_adapter.MyViewHolder> {

    private Context context;
    private List<Players_obj> Toplayerdata;

    public Toplayer_adapter(Context context, List<Players_obj> toplayerdata) {
        this.context = context;
        this.Toplayerdata = toplayerdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.topplayer_content, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.playername.setText(Toplayerdata.get(position).getName());
        holder.playergame.setText(Toplayerdata.get(position).getGame());
        holder.description.setText(Toplayerdata.get(position).getBiografia());

        if (Toplayerdata.get(position).getAvatar() != "Jugador sin imagen") {
            Picasso.with(context).load(Toplayerdata.get(position).getAvatar()).into(holder.playeravatar);


        }
    }

        @Override
        public int getItemCount () {
            return Toplayerdata.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView playername;
            private TextView playergame;
            private ImageView playeravatar;
            private TextView description;


            public MyViewHolder(View views) {
                super(views);

                playername = (TextView) itemView.findViewById(R.id.name);
                playergame = (TextView) itemView.findViewById(R.id.game_player);
                playeravatar = (ImageView) itemView.findViewById(R.id.avatar);
                description = (TextView) itemView.findViewById(R.id.description);
            }
        }

    }
