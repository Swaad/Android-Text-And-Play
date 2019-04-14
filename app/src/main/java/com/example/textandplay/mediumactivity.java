package com.example.textandplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mediumactivity extends AppCompatActivity {

    private Button mgame1;
    private  Button mgame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediumactivity);

        mgame1 = (Button)findViewById(R.id.game1);
        mgame2= (Button)findViewById(R.id.game2);

       mgame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mediumactivity.this,SplashActivity.class));

            }
        });
       mgame2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(mediumactivity.this,MainActivity5.class));
           }
       });
    }
}
