package com.example.javier.gamenews.Actividades.Vistas_iniciales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javier.gamenews.Actividades.MainActivity;
import com.example.javier.gamenews.Actividades.conexion;
import com.example.javier.gamenews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.javier.gamenews.Actividades.objects.Usuario;


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

                            if(response.code() !=401){
                                token = response.body().getToken().toString();
                               vista = new Intent(getApplicationContext(), MainActivity.class);
                               startActivity(vista);
                            }
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"No hay Internet",Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });

        }

        public interface LoginListener{
            void cargardatos(String username, String password, boolean signed);
        }


    }



