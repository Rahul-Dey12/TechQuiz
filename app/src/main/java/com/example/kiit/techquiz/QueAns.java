package com.example.kiit.techquiz;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QueAns extends AppCompatActivity {
    QaAdapter qaAdapter;
    ArrayList<Data> dataArrayList;
    ListView listView;
    TextView tvname, tvscore;
    Button submit;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_ans);

        listView = (ListView) findViewById(R.id.listview);
        submit = (Button) findViewById(R.id.button);
        dataArrayList = new ArrayList<Data>();
        tvname=(TextView)findViewById(R.id.textView);
        tvscore = (TextView) findViewById(R.id.textView2);
        qaAdapter = new QaAdapter(this, R.layout.activity_que_ans, dataArrayList);
        listView.setAdapter(qaAdapter);
        preparedata();
        Intent intent = new Intent(QueAns.this, Welcome.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[]=qaAdapter.getAns();
                count=0;
                for(int i=0;i<a.length;i++)
                    if(a[i]==1)
                        count++;
                //Toast.makeText(QueAns.this, "" + count, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(QueAns.this,Score.class);
                i.putExtra("score",count);
                startActivity(i);
                finish();
            }
        });
        //Toast.makeText(QueAns.this,""+qaAdapter.getAnInt(),Toast.LENGTH_SHORT).show();

        tvname.setText("Name : "+getIntent().getExtras().getString("name"));


    }

    public void preparedata() {
        Data data;
        data = new Data("1. What is Full form of ATM", "A. Automatic Teller Machine", "B. Automated Teller Machine", "C. Automated Transactions Machine", "D. Automatic Transactions Machine", 2);
        dataArrayList.add(data);
        data = new Data("2. Founders of Google", "A. Lerry Page", "B. Sergey Brin", "C. Sundar Pichai", "D. A&B both", 4);
        dataArrayList.add(data);
        data = new Data("3. What is Full form of HP", "A. Hewlett-Packard", "B. Hewlett-Package", "C. Hewlett-Product", "D. None", 1);
        dataArrayList.add(data);
        data = new Data("4. Samsung is a", "A. Indian Comapany", "B. Chaina Company", "C. South Korea Comapany", "D. US Company", 3);
        dataArrayList.add(data);
        data = new Data("5. What is full form of USB", "A. Unidirectional Serial Bus", "B. Universal Seria Bus", "C. Unidirectional Standard Bus", "D. Universal Standard Bus", 2);
        dataArrayList.add(data);
        data = new Data("6. What is full form of SMS", "A. Short Message Service", "B. Short Message Send", "C. Send Short Message", "D. None", 1);
        dataArrayList.add(data);
        data = new Data("7. Whic among follwing is not a programming language", "A. Php", "B. Java", "C. IEEE", "D. Perl", 3);
        dataArrayList.add(data);
        data = new Data("8. Who is CEO of microsoft", "A. Bill Gates", "B. Satya Nadelaa", "C. Sundar Pichai", "D. None", 2);
        dataArrayList.add(data);
        data = new Data("9. Whic is not a google product", "A. Firebase", "B. Chrome", "C. Youtube", "D. Facebook", 4);
        dataArrayList.add(data);
        data = new Data("10. Developer of WhatsApp", "A. Google", "B. Facebook", "C. Android", "D. Own", 2);
        dataArrayList.add(data);
        qaAdapter.notifyDataSetChanged();
    }
}
