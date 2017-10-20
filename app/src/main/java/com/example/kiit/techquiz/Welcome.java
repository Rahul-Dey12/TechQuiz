package com.example.kiit.techquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mediaPlayer=MediaPlayer.create(this,R.raw.welcome);
        mediaPlayer.start();
        b=(Button)findViewById(R.id.start);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)
                    mediaPlayer.stop();
                Intent intent=new Intent(Welcome.this,NamePass.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
