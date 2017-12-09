package com.example.lge.fin01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        final DBHelper dbHelper = new DBHelper( getActivity().getApplicationContext(), " Diary.db", null, 1);



        final EditText etDate = (EditText) view.findViewById(R.id.date);
        final EditText etitem = (EditText) view.findViewById(R.id.menu);
        final EditText etprice = (EditText) view.findViewById(R.id.price);
        final TextView result = (TextView) view.findViewById(R.id.result);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        etDate.setText(simpleDateFormat.format(date));


        //add data
        Button add = (Button) view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String menu = etitem.getText().toString();
                int price = Integer.parseInt(etprice.getText().toString());

                dbHelper.add(date, menu, price);
                result.setText(dbHelper.getResult());
            }
        });



        // delete data
        Button delete = (Button) view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etitem.getText().toString();

                dbHelper.delete(name);
                result.setText(dbHelper.getResult());
            }
        });


        return view;
    }





}

