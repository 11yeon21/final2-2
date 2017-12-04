package com.example.lge.fin01;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private int i = 0;
    private TextView myi;
    private ImageView imageView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);


        myi = (TextView) view.findViewById(R.id.i);
        imageView = (ImageView) view.findViewById(R.id.myImageView);

        return view;
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            updateThread();
        }
    };



    @Override
    public void onStart() {
        super.onStart();

        Thread myThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(1000);
                    } catch (Throwable t) {
                    }
                }
            }
        });

        myThread.start();
    }

    private void updateThread() {

        int mod = i % 4;

        switch (mod) {
            case 0:
                i++;
                imageView.setImageResource(R.drawable.rabbit01);
                break;
            case 1:
                i++;
                imageView.setImageResource(R.drawable.rabbit02);
                break;
            case 2:
                i++;
                imageView.setImageResource(R.drawable.rabbit03);
                break;
            case 3:
                i = 0;
                imageView.setImageResource(R.drawable.rabbit04);
                break;
        }
        myi.setText(String.valueOf(i));
    }



}















