package com.example.serializacionjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userET,nameET,emailET,uviET;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userET= findViewById(R.id.userET);
        emailET=findViewById(R.id.emailET);
        uviET=findViewById(R.id.uviET);
        userET=findViewById(R.id.userET);

        regBtn=findViewById(R.id.regBtn);

        regBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("SerializacionJSON",MODE_PRIVATE);
        String json = preferences.getString("tempuser","NO_OBJ");
        if(!json.equals("NO_OBJ")){
            Gson gson= new Gson();
            Estudiante estudiante=gson.fromJson(json,Estudiante.class);
            nameET.setText(estudiante.getNombre());
            emailET.setText(estudiante.getEmail());
            uviET.setText(estudiante.getUniversity());
            userET.setText(estudiante.getUsername());
        }

    }

    @Override
    protected void onPause() {

        String  name = nameET.getText().toString();
        String email= emailET.getText().toString();
        String user= userET.getText().toString();
        String univ= uviET.getText().toString();

        Estudiante  estudiante= new Estudiante(name,email,univ,user);
        //JSON
        Gson gson= new Gson();
        String json = gson.toJson(estudiante);
        Toast.makeText(this, json,Toast.LENGTH_LONG).show();
        Log.e(">>>", ""+json);
//alamcenarlo en el local storage
        //local strogae=sharedpreferencs
        SharedPreferences preferences = getSharedPreferences("SerializacionJSON",MODE_PRIVATE);
        preferences.edit().putString("tempuser",json)
                .putString("alfa", "valor1")
                .putString("beta", "valor2")
                .apply();

        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regBtn:


                break;
        }

    }
}