package com.example.kiit.techquiz;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    TextView score;
    MediaPlayer mp;
    Vibrator vibrator;
    int songs[]={R.raw.zero,R.raw.one,R.raw.two,R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,R.raw.nine,R.raw.ten};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        score=(TextView)findViewById(R.id.score);

        int scoreval=getIntent().getExtras().getInt("score");
        vibrator.vibrate(scoreval*1000);
        score.setText(scoreval+" /10");
        mp=MediaPlayer.create(this,songs[scoreval]);
        mp.start();
    }
}
