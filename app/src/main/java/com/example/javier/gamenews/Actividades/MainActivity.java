package com.example.javier.gamenews.Actividades;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.javier.gamenews.Actividades.fragments.ContenedorFragment;
import com.example.javier.gamenews.Actividades.fragments.NewsFragment;
import com.example.javier.gamenews.Actividades.objects.News_obj;
import com.example.javier.gamenews.R;

import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public String filtrador;
    public ContenedorFragment contenedorFragment;
    private Fragment actualFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_news);
        changeFragment(new NewsFragment());

       }


       //Validando cierre de sesion
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Salir de la app");
            alertDialogBuilder
                    .setMessage("¿Quieres salir?")
                    .setCancelable(false)
                    .setPositiveButton("Si",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        switch (id) {
            case R.id.nav_news:
                changeFragment(new NewsFragment());
                break;

            case R.id.nav_lol:
                filtrador = "lol";
                contenedorFragment = new ContenedorFragment();
                contenedorFragment.filtrador(filtrador);
                changeFragment(contenedorFragment);
                break;

            case R.id.nav_csgo:
                filtrador = "csgo";
                contenedorFragment = new ContenedorFragment();
                contenedorFragment.filtrador(filtrador);
                changeFragment(contenedorFragment);
                break;

            case R.id.nav_dota2:
                filtrador = "overwatch";
                contenedorFragment = new ContenedorFragment();
                contenedorFragment.filtrador(filtrador);
                changeFragment(contenedorFragment);
                break;



            case R.id.nav_settings:
                changeFragment(new ContenedorFragment());
                break;

            case R.id.nav_favoritos:
                changeFragment(new ContenedorFragment());
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void changeFragment(Fragment fragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
            actualFragment = fragment;

    }




}









