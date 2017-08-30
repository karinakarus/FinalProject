package com.example.karindra.kpsp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {




        @Override
            protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.halaman_awal);

            Button InputDataBaru = (Button) findViewById(R.id.btnInputDataBaru);
             InputDataBaru.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent = new Intent (MainActivity.this, Activity_InputData.class);
                     startActivity(intent);
                 }
             });

            Button Riwayat = (Button) findViewById(R.id.btnRiwayat);
            Riwayat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent (MainActivity.this, Activity_Riwayat.class);
                    startActivity(intent);
                }
            });
        }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Anda ingin keluar dari Aplikasi ini?").setCancelable(false).setPositiveButton("YA", new DialogInterface.OnClickListener() {
            public void onClick (DialogInterface dialog, int id) {
                MainActivity.this.finish();
            }
        }).setNegativeButton("TIDAK", null).show();
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    }




