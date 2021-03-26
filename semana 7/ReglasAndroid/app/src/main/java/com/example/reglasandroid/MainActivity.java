package com.example.reglasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements Counter.onCounterChange, View.OnClickListener{

    private TextView counterTV;
    private Counter counter;
    private HTTPUtil util;


    private EditText urlET;
    private TextView outputTV;
    private Button actionBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTV = findViewById(R.id.counterTV);
        urlET= findViewById(R.id.urlET);
        actionBtn=findViewById(R.id.actionBtn);
        outputTV=findViewById(R.id.outputTV);

        counter = new Counter();
        counter.setObserver(this);
        counter.start();

        actionBtn.setOnClickListener(this);
    }

    @Override
    public void onCounterValue(int value) {
        //Esta corriendo en el worker
        runOnUiThread(
                ()->{
                    counterTV.setText(""+value);
                }
        );
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.actionBtn:
                String url = urlET.getText().toString();
                util = new HTTPUtil(url);
                util.start();
                util.setObserver(
                        response -> {
                            runOnUiThread(
                                    ()->{
                                        outputTV.setText(response);
                                    }
                            );
                        }
                );

                break;
        }
    }





}