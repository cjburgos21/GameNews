package com.example.javier.gamenews.Actividades.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VPadapter extends FragmentPagerAdapter{

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    public VPadapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }


    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }


    @Override
    public int getCount(){
        return stringList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return stringList.get(position);
    }

    public void addfragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }

}
