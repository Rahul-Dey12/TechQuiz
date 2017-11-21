package com.example.kiit.techquiz;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Score extends AppCompatActivity {
    TextView score;
    TextView tvname;
    MediaPlayer mp;
    Vibrator vibrator;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    int songs[]={R.raw.zero,R.raw.one,R.raw.two,R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,R.raw.nine,R.raw.ten};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        score=(TextView)findViewById(R.id.score);
        tvname=(TextView)findViewById(R.id.textView);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        int scoreval=getIntent().getExtras().getInt("score");
        String name=getIntent().getExtras().getString("name");
        vibrator.vibrate(scoreval*1000);
        tvname.setText(name+"\nYour Score is");
        score.setText(scoreval+" /10");

        HashMap<String,String> data=new HashMap<String, String>();

        data.put("Name",name.trim());
        data.put("Score",""+scoreval);

        databaseReference.push().setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(Score.this, "congratulation..", Toast.LENGTH_SHORT).show();
            }
        });
        mp=MediaPlayer.create(this,songs[scoreval]);
        mp.start();
    }
}
