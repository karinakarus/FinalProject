package com.example.karindra.kpsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_PilihUmur extends AppCompatActivity {
ListView listView;
    String[] isilistumur = new String[] {"UMUR 3 BULAN", "UMUR 6 BULAN", "UMUR 9 BULAN", "UMUR 12 BULAN",
            "UMUR 15 BULAN", "UMUR 18 BULAN", "UMUR 21 BULAN", "UMUR 24 BULAN", "UMUR 30 BULAN", "UMUR 36 BULAN",
            "UMUR 42 BULAN", "UMUR 48 BULAN", "UMUR 54 BULAN", "UMUR 60 BULAN", "UMUR 66 BULAN", "UMUR 72 BULAN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihumur);



        listView = (ListView) findViewById(R.id.listumur);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,isilistumur);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long id) {
                if (posisi == 0) {
                    Intent myintent = new Intent(view.getContext(), KPSP3BULAN.class);
                    startActivityForResult(myintent, 0);
                }

                if (posisi == 1) {
                    Intent myintent = new Intent(view.getContext(), KPSP6BULAN.class);
                    startActivityForResult(myintent, 1);
                }

                if (posisi == 2) {
                    Intent myintent = new Intent(view.getContext(),KPSP9BULAN.class);
                    startActivityForResult(myintent, 2);
                }
                if (posisi == 3) {
                    Intent myintent = new Intent(view.getContext(), KPSP12BULAN.class);
                    startActivityForResult(myintent, 3);
                }
                if (posisi == 4) {
                    Intent myintent = new Intent(view.getContext(),KPSP15BULAN.class);
                    startActivityForResult(myintent, 4);
                }
                if (posisi == 5) {
                    Intent myintent = new Intent(view.getContext(), KPSP18BULAN.class);
                    startActivityForResult(myintent, 5);
                }
                if (posisi == 6) {
                    Intent myintent = new Intent(view.getContext(), KPSP21BULAN.class);
                    startActivityForResult(myintent, 6);
                }
                if (posisi == 7) {
                    Intent myintent = new Intent(view.getContext(), KPSP24BULAN.class);
                    startActivityForResult(myintent, 7);
                }
                if (posisi == 8) {
                    Intent myintent = new Intent(view.getContext(), KPSP30BULAN.class);
                    startActivityForResult(myintent, 8);
                }
                if (posisi == 9) {
                    Intent myintent = new Intent(view.getContext(), KPSP36BULAN.class);
                    startActivityForResult(myintent, 9);
                }
                if (posisi == 10) {
                    Intent myintent = new Intent(view.getContext(), KPSP42BULAN.class);
                    startActivityForResult(myintent, 10);
                }
                if (posisi == 11) {
                    Intent myintent = new Intent(view.getContext(), KPSP48BULAN.class);
                    startActivityForResult(myintent, 11);
                }
                if (posisi == 12) {
                    Intent myintent = new Intent(view.getContext(), KPSP54BULAN.class);
                    startActivityForResult(myintent, 12);
                }
                if (posisi == 13) {
                    Intent myintent = new Intent(view.getContext(), KPSP60BULAN.class);
                    startActivityForResult(myintent, 13);
                }
                if (posisi == 14) {
                    Intent myintent = new Intent(view.getContext(), KPSP66BULAN.class);
                    startActivityForResult(myintent, 14);
                }
                if (posisi == 15) {
                    Intent myintent = new Intent(view.getContext(), KPSP72BULAN.class);
                    startActivityForResult(myintent, 15);
                }

            }
        });
    }

}

