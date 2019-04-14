package com.example.textandplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        Thread thread = new Thread()

        {
            @Override
            public void run() {
             try {
                 sleep(5000);

             }catch (Exception e)
             {
                   e.printStackTrace();
             }
             finally {

                 Intent mainIntent =  new Intent(SplashActivity.this, MainActivity2.class);
                 startActivity(mainIntent);
             }
            }
        };
        thread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
