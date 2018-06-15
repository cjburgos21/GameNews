package com.example.javier.gamenews.Actividades.Vistas_iniciales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.javier.gamenews.R;

public class Register extends AppCompatActivity {

    private EditText newuser;
    private EditText newpassword;
    private ImageView imgbutton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
