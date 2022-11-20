package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        Thread thread =new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);

                }
                catch(Exception E){
                    E.printStackTrace();

                }
                finally{
                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
                super.run();
            }
        };
        thread.start();
    }

}
