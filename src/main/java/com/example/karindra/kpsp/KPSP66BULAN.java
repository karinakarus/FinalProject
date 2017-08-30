package com.example.karindra.kpsp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KPSP66BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp66_bulan);

        btnYA = (Button) findViewById(R.id.btnYA);
        btnTIDAK = (Button) findViewById(R.id.btnTIDAK);
        txtPertanyaan = (TextView) findViewById(R.id.txtPertanyaan);
        score = (TextView) findViewById(R.id.score);
        imageView = (ImageView) findViewById(R.id.imageView);

        updateQuestion();


        btnYA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer == true){
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP66BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP66BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP66BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP66BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

        btnTIDAK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == false){
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP66BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP66BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP66BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP66BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        imageView.setImageResource(Questions15.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions15.mQuestions[mQuestionsnumber]);
        mAnswer = Questions15.answers[mQuestionsnumber];
        mQuestionsnumber++;
    }

    private void updateScore(int point) {
        score.setText("" + mScore);
    }

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP66BULAN.this);
        builder.setMessage("Anda ingin keluar dari Aplikasi ini?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

class Questions14 {
    public static String mQuestions [] =  new String[]{
            "1.	Jangan membantu anak dan jangan memberitahu nama gambar ini, suruh anak menggambar seperti contoh ini di kertas kosong yang tersedia. Berikan 3 kali kesempatan. Apakah anak dapat menggambar seperti contoh ini?",
            "2.	Ikuti perintah ini dengan seksama. Jangan memberi isyarat dengan telunjuk atau mats pads saat memberikan perintah berikut ini: 'Letakkan kertas ini di atas lantai'. 'Letakkan kertas ini di bawah kursi'. 'Letakkan kertas ini di depan kamu' 'Letakkan kertas ini di belakang kamu' ",
            "3.	Apakah anak bereaksi dengan tenang dan tidak rewel (tanpa menangis atau menggelayut pada anda) pada saat anda meninqgalkannya?",
            "4.  Jangan menunjuk, membantu atau membetulkan, katakan pada anak : 'Tunjukkan segi empat merah'  'Tunjukkan segi empat kuning'  'Tunjukkan segi empat biru'  'Tunjukkan segi empat hijau'",
            "5.	Suruh anak melompat dengan satu kaki beberapa kali tanpa berpegangan (lompatan dengan dua kaki tidak ikut dinilai). Apakah ia dapat melompat 2-3 kali dengan satu kaki? ",
            "6.	Dapatkah anak sepenuhnya berpakaian sendiri tanpa bantuan? ",
            "7.	Suruh anak menggambar di tempat kosong yang tersedia. Katakan padanya: 'Buatlah gambar orang'. Jangan memberi perintah lebih dari itu. Jangan bertanya/ mengingatkan anak bila ada bagian yang belum tergambar. Dalam memberi nilai, hitunglah berapa bagian tubuh yang tergambar. Untuk bagian tubuh yang berpasangan seperti mata, telinga, lengan dan kaki, setiap pasang dinilai satu bagian. Dapatkah anak menggambar sedikitnya 3 bagian tubuh? ",
            "8.	Pada gambar orang yang dibuat pada nomor 7, dapatkah anak menggambar sedikitnya 6 bagian tubuh? ",
            "9.	Tulis apa yang dikatakan anak pada kalimat-kalimat yang belum selesai ini, jangan membantu kecuali mengulang pertanyaan:     Jika kuda besar maka tikus ………    Jika api panas maka es ………    Jika ibu seorang wanita maka ayah seorang ………   ",
            "10.Apakah anak dapat menangkap bola kecil sebesar bola tenis/bola kasti hanya dengan menggunakan kedua tangannya? (Bola besar tidak ikut dinilai). "





    };

    public static int[] images = new int[] {
            R.drawable.img_15_1, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_15_4, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_14_8, R.drawable.img_blank, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







