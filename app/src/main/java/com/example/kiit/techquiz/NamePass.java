package com.example.kiit.techquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NamePass extends AppCompatActivity {
    EditText edn,edp;
    Button bt;
    TextView error;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_pass);

        edn=(EditText)findViewById(R.id.editText);
        edp=(EditText)findViewById(R.id.editText2);
        bt=(Button)findViewById(R.id.button);
        error=(TextView)findViewById(R.id.textView);

        mp = MediaPlayer.create(this, R.raw.namepass);
        mp.start();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,password;
                name=edn.getText().toString();
                password=edp.getText().toString();
                if(password.equals("123"))
                {
                    Intent i=new Intent(NamePass.this,QueAns.class);
                    i.putExtra("name",name);
                    startActivity(i);
                    finish();
                }
                else {
                    //Toast.makeText(NamePass.this,password,Toast.LENGTH_SHORT).show();
                    error.setVisibility(View.VISIBLE);
                        if(mp!=null)
                            mp.stop();
                        mp = MediaPlayer.create(NamePass.this, R.raw.tryagain);
                        mp.start();
                }
            }
        });
    }
}
