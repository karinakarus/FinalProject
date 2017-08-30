package com.example.karindra.kpsp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_RincialHasil extends AppCompatActivity {
    TextView mHasil, mNasihat, mJawaban;
    public static final String PREFS = "Activity_InputData.KEY";
    TextView txtNo, txtNama_Anak, txtTgl_Lhr, txtUsia, txtBerat_Badan, txtHasil;
    Button mSimpan, mKeluar;
    DataHelper dataHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincialhasil);

        dataHelper = new DataHelper(this);
        mHasil = (TextView) findViewById(R.id.txtHasil);
        mNasihat = (TextView) findViewById(R.id.txtNasihat);
        mJawaban = (TextView) findViewById(R.id.txtScore);
        txtHasil = (TextView) findViewById(R.id.txtHasil);

///////////////////////////// Menampilkan data SharedPreferences dari Activity_InpuData ///////////////////////////////////////////////////////

        txtNo = (TextView) findViewById(R.id.txtNo);
        txtNama_Anak = (TextView) findViewById(R.id.txtNama_Anak);
        txtTgl_Lhr = (TextView) findViewById(R.id.txtTgl_Lhr);
        txtUsia = (TextView) findViewById(R.id.txtUsia);
        txtBerat_Badan = (TextView) findViewById(R.id.txtBerat_Badan);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, 0);
        String No = sharedPreferences.getString("dataNo", "");
        String Nama = sharedPreferences.getString("dataNama", "");
        String Tgl = sharedPreferences.getString("dataTgl", "");
        String Umur = sharedPreferences.getString("dataUmur", "");
        String Berat = sharedPreferences.getString("dataBerat", "");

        txtNo.setText(No);
        txtNama_Anak.setText(Nama);
        txtTgl_Lhr.setText(Tgl);
        txtUsia.setText(Umur);
        txtBerat_Badan.setText(Berat);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        mSimpan = (Button) findViewById(R.id.btnSimpan);
        mSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("INSERT INTO data_anak (id_anak, nama_anak, tgl_lhr, umur, berat_badan, hasil) values ('" + txtNo.getText().toString() + "','" + txtNama_Anak.getText().toString() + "','" + txtTgl_Lhr.getText().toString() + "','" + txtUsia.getText().toString() + "','" + txtBerat_Badan.getText().toString() + "','" + txtHasil.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "DATA BERHASIL DISIMPAN", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        mKeluar = (Button) findViewById(R.id.btnKeluar);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mJawaban.setText("Jumlah jawaban YA sebanyak : " + score);
        if (score == 10){
            mHasil.setText("Perkembangan SESUAI (S)");
            mNasihat.setText("1. Orangtua/pengasuh anak sudah mengasuh anak dengan baik.\n" +
                    "2. Pola asuh anak selanjutnya terus lakukan sesuai dengan bagan stimulasi sesuaikan dengan umur dan kesiapan anak.\n" +
                    "3. Keterlibatan orangtua sangat baik dalam tiap kesempatan stimulasi. Tidak usah mengambil momen khusus. Laksanakan stimulasi sebagai kegiatan sehari-hari yang terarah.\n" +
                    "4. Ikutkan anak setiap ada kegiatan Posyandu.");

        }else if (score == 9){
            mHasil.setText("Perkembangan SESUAI (S)");
            mNasihat.setText("1. Orangtua/pengasuh anak sudah mengasuh anak dengan baik.\n" +
                    "2. Pola asuh anak selanjutnya terus lakukan sesuai dengan bagan stimulasi sesuaikan dengan umur dan kesiapan anak.\n" +
                    "3. Keterlibatan orangtua sangat baik dalam tiap kesempatan stimulasi. Tidak usah mengambil momen khusus. Laksanakan stimulasi sebagai kegiatan sehari-hari yang terarah.\n" +
                    "4. Ikutkan anak setiap ada kegiatan Posyandu.");

        }else if (score == 8) {
            mHasil.setText("Ada Penyimpangan");
            mNasihat.setText(
                    "1. Lakukan KPSP ulang setelah 2 minggu menggunakan daftar KPSP yang sama pada saat anak pertama dinilai.\n" +
                    "2. Bila usia anak sudah berpindah golongan dan KPSP yang pertama sudah bisa semua dilakukan. Lakukan lagi untuk KPSP yang sesuai umur anak.\n" +
                    "3. Lakukan skrining rutin, pastikan anak tidak mengalami ketertinggalan lagi.\n" +
                    "4. Bila setelah 2 minggu intensif stimulasi, jawaban masih = 7-8 jawaban YA. Konsultasikan dengan dokter spesialis anak atau ke rumah sakit dengan fasilitas klinik tumbuh kembang.\n" +
                    "\n");


        }else if (score == 7) {
            mHasil.setText("Ada Penyimpangan");
            mNasihat.setText("1. Lakukan KPSP ulang setelah 2 minggu menggunakan daftar KPSP yang sama pada saat anak pertama dinilai.\n" +
                    "2. Bila usia anak sudah berpindah golongan dan KPSP yang pertama sudah bisa semua dilakukan. Lakukan lagi untuk KPSP yang sesuai umur anak.\n" +
                    "3. Lakukan skrining rutin, pastikan anak tidak mengalami ketertinggalan lagi.\n" +
                    "4. Bila setelah 2 minggu intensif stimulasi, jawaban masih = 7-8 jawaban YA. Konsultasikan dengan dokter spesialis anak atau ke rumah sakit dengan fasilitas klinik tumbuh kembang.\n" +
                    "\n");


        }else {
            mHasil.setText("Ada Penyimpangan");
            mNasihat.setText("Konsultasikan dengan dokter spesialis anak atau ke rumah sakit dengan fasilitas klinik tumbuh kembang.");
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Anda ingin keluar dari Aplikasi ini?").setCancelable(false).setPositiveButton("YA", new DialogInterface.OnClickListener() {
            public void onClick (DialogInterface dialog, int id) {
                Activity_RincialHasil.this.finish();
            }
        }).setNegativeButton("TIDAK", null).show();
    }
}
