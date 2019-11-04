package com.example.psp_hilos_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        Intent intent = getIntent();
        num = intent.getIntExtra("mensaje", 1);

        if (num == 1){
            textView.setText("Vengo del Hilo");
        }else if (num == 2){
            textView.setText("Vengo del Asynctask");
        }
    }

    void init(){
        textView = findViewById(R.id.textView);
    }
}
