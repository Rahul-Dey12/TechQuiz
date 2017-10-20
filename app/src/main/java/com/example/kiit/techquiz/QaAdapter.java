package com.example.kiit.techquiz;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QaAdapter extends ArrayAdapter {
    private ArrayList<Data> datas;
    private Context context;
    private int anInt=0;
    public int ans[]=new int[10];

    //public int anInt;
    public QaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Data> datas) {
        super(context, resource, datas);
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        if (convertView != null) {
            v = convertView;
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.qalist, parent, false);
        }

        TextView tvque = (TextView) v.findViewById(R.id.textView);
        String que = datas.get(position).getQue();
        tvque.setText(que);


        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        final ArrayList<String> anslist = new ArrayList<String>();
        anslist.add(datas.get(position).getAns1());
        anslist.add(datas.get(position).getAns2());
        anslist.add(datas.get(position).getAns3());
        anslist.add(datas.get(position).getAns4());
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, anslist);
        spinner.setAdapter(adapter);
        //spinner.setSelection(0,true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positionsp, long id) {

                try {
                    if(datas.get(position).getRightans()==positionsp+1){
                        ans[position]=1;
                    }
                    else {
                        ans[position]=0;}
                }catch (Exception e){}


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Toast.makeText(context,"nf",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    public int[] getAns() {
        return ans;
    }

    public int getAnInt() {
        return anInt;
    }
}
