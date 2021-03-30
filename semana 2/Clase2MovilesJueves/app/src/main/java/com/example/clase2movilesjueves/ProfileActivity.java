package com.example.clase2movilesjueves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private Button volverBtn;
    private EditText newUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getExtras().getString("username");
        newUsername.setText(username);

        volverBtn = findViewById(R.id.volverBtn);
        newUsername = findViewById(R.id.newUsername);
        volverBtn.setOnClickListener(
                (v)-> {

                    Intent data = new Intent();
                    data.putExtra("username",newUsername.getText().toString());
                    setResult(RESULT_OK,data);
                    finish();
                }

        );
    }
}