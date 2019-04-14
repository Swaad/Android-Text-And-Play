package com.example.textandplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameOverActivity extends AppCompatActivity {

    private Button StartGameAgain;
    private TextView DisplayScore;
    private  String score;
    private Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        score = getIntent().getExtras().get("score").toString();
       DisplayScore = findViewById(R.id.displayScore);
        StartGameAgain = (Button) findViewById(R.id.play_again_btn);
        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent =  new Intent(GameOverActivity.this, MainActivity2.class);
                startActivity(mainIntent);
            }
        });

        quit = (Button) findViewById(R.id.quitbutton);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameOverActivity.this,MainActivity.class));
            }
        });

    DisplayScore.setText("Score : "+score);
        FriendlyMessage friendlyMessage = new FriendlyMessage("score is "+score+" in Fly and Catch", null, null);

        FirebaseDatabase mFirebaseDatabase;
        mFirebaseDatabase  = FirebaseDatabase.getInstance();
         DatabaseReference mMessagesDatabaseReference;
          mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");

        mMessagesDatabaseReference.push().setValue(friendlyMessage);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.push().setValue(friendlyMessage);



    }
}
