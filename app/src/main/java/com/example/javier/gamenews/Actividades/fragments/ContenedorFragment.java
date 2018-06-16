package com.example.javier.gamenews.Actividades.fragments;

import android.support.v7.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.gamenews.R;

import com.example.javier.gamenews.Actividades.adapters.VPadapter;

public class ContenedorFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VPadapter vadapter;
    public String aux2;
    public String aux4;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contenedor, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        vadapter = new VPadapter(getChildFragmentManager());


        //Generals generals = new Generals();
        //generals.filtrador2(aux4);
        vadapter.addfragment(new Generals(), "Generals");


        TopPlayers topPlayers = new TopPlayers();
        topPlayers.filtrador(aux2);
        vadapter.addfragment(topPlayers, "Top_Players");

        vadapter.addfragment(new Images(), "Images");
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));

        viewPager.setAdapter(vadapter);
        tabLayout.setupWithViewPager(viewPager);


        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setElevation(0);

        return view;

    }
    public String filtrador(String aux){
        aux2 = aux;
        return aux2;
    }

    /*public String filtrador2(String aux3){
        aux4 = aux3;
        return aux4;
    }*/

}
