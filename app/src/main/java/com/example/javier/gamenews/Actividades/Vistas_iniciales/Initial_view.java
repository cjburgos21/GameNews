package com.example.javier.gamenews.Actividades.Vistas_iniciales;
import com.example.javier.gamenews.Actividades.Vistas_iniciales.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.javier.gamenews.R;

public class Initial_view extends AppCompatActivity {
    TextView loginfin;
    TextView register;
    boolean estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_view);

        loginfin = findViewById(R.id.login_active);
        loginfin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Login.class);
                startActivity(intent);
            }

        });
    }

}