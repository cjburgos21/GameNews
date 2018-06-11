package com.example.javier.gamenews.Actividades;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.javier.gamenews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.Manifest.permission.READ_CONTACTS;

import com.example.javier.gamenews.Actividades.Usuario;
import com.example.javier.gamenews.Actividades.conexion;
import com.example.javier.gamenews.R;


public class Login extends AppCompatActivity {

    private EditText usernam;
    private EditText passthis;
    private Button button1;
    private conexion conexion1;
    private String direccion;
    private Retrofit retrofit;
    private Call<Usuario> llamar;
    public static String token;
    private Intent vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            usernam = findViewById(R.id.email);
            passthis = findViewById(R.id.password);
            button1 = findViewById(R.id.sign_in_button);


            direccion = "http://gamenewsuca.herokuapp.com/";

            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(direccion)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            conexion1 = retrofit.create(conexion.class);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    llamar = conexion1.logrequest(usernam.getText().toString(), passthis.getText().toString());

                    llamar.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                            if(response.body().getToken() != null){
                                token = response.body().getToken().toString();
                                vista = new Intent(Login.this,MainActivity.class);
                                startActivity(vista);
                            }
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {

                        }
                    });


                }
            });

        }



    }



