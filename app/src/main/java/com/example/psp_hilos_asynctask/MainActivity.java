package com.example.psp_hilos_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btHilo;
    private Button btAsynctask;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                new Hilo().start();
                btHilo.setClickable(false);
                btAsynctask.setClickable(false);
            }
        });

        btAsynctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                new HiloAsynctask().execute();
            }
        });
    }

    void init(){
        btHilo = findViewById(R.id.btHilo);
        btAsynctask = findViewById(R.id.btAsynctask);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setMax(20);
        btHilo.setClickable(true);
        btAsynctask.setClickable(true);
        btAsynctask.setClickable(true);
    }

    class Hilo extends Thread {
        @Override
        public void run() {
            for (int i = 1; i<=20; i++){
                progressBar.setProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("mensaje",1);
            startActivity(intent);
            progressBar.setVisibility(View.INVISIBLE);
            btAsynctask.setClickable(true);
            btAsynctask.setClickable(true);
        }
    }

    class HiloAsynctask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i<=20; i++){
                progressBar.setProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("mensaje",2);
            startActivity(intent);
            progressBar.setVisibility(View.INVISIBLE);
            btAsynctask.setClickable(true);
            btAsynctask.setClickable(true);
            return null;
        }
    }
}


