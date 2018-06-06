package fragmentos;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
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

import adaptadores.VPadapter;

public class ContenedorFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VPadapter vadapter;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contenedor, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        vadapter = new VPadapter(getChildFragmentManager());

        vadapter.addfragment(new Generals(), "Generals");
        vadapter.addfragment(new TopPlayers(), "Top_Players");
        vadapter.addfragment(new Images(), "Images");
        tabLayout.setTabTextColors(Color.parseColor("#81F7F3"), Color.parseColor("#ffffff"));

        viewPager.setAdapter(vadapter);
        vadapter.setupWithViewPager(viewPager);


        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setElevation(0);

        return view;

    }

}
