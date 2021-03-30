package com.example.clase2movilesjueves;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//primer metodo que se ejecuta en una actividad

    private EditText loginUsername;
    private EditText loginPassword;
    private Button sesionBtn;
    private static final int CODE = 16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        sesionBtn= findViewById(R.id.sesionBtn);
        sesionBtn.setOnClickListener(

                (v) -> {

                    String username = loginUsername.getText().toString();
                    String password = loginPassword.getText().toString();
                    //Toast.makeText(this,username + " " + password, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, ProfileActivity.class);
                    intent.putExtra("username",username);
                    startActivityForResult(intent,CODE);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CODE && resultCode == RESULT_OK){
            String username = data.getExtras().getString("username");
            loginUsername.setText(username);
        }
    }

//Control + O


}