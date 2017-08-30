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

public class KPSP60BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp60_bulan);

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
                        Intent i = new Intent(KPSP60BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP60BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP60BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP60BULAN.this.finish();
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
                        Intent i = new Intent(KPSP60BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP60BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP60BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP60BULAN.this.finish();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP60BULAN.this);
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

class Questions13 {
    public static String mQuestions [] =  new String[]{
            "1.	Isi titik-titik di bawah ini dengan jawaban anak. Jangan membantu kecuali mengulangi pertanyaan. 'Apa yang kamu lakukan jika kamu kedinginan?' 'Apa yang kamu lakukan jika kamu lapar?' 'Apa yang kamu lakukan jika kamu lelah?'  Jawab YA biia anak merjawab ke 3 pertanyaan tadi dengan benar, bukan dengan gerakan atau isyarat",
            "2.	Apakah anak dapat mengancingkan bajunya atau pakaian boneka?",
            "3.	Suruh anak berdiri satu kaki tanpa berpegangan. Jika perlu tunjukkan caranya dan beri anak ands kesempatan melakukannya 3 kali. Dapatkah ia mempertahankan keseimbangan dalam waktu 6 detik atau lebih?",
            "4.	Jangan mengoreksi/membantu anak. Jangan menyebut kata 'lebih panjang',  Perlihatkan gambar kedua garis ini pada anak. Tanyakan: “Mana garis yang lebih panjang?”  Minta anak menunjuk garis yang lebih panjang",
            "5.	Jangan membantu anak dan jangan memberitahu nama gambar ini, suruh anak menggambar  seperti contoh ini di kertas kosong yang tersedia. Berikan 3 kali kesempatan. Apakah anak dapat menggambar seperti contoh ini?",
            "6.	Ikuti perintah ini dengan seksama. Jangan memberi isyarat dengan telunjuk atau mats pads saat memberikan perintah berikut ini: 'Letakkan kertas ini di atas lantai'.  'Letakkan kertas ini di bawah kursi'  'Letakkan kertas ini di depan kamu'  'Letakkan kertas ini di belakang kamu'",
            "7.	Apakah anak bereaksi dengan tenang dan tidak rewel (tanpa menangis atau menggelayut pada anda) pada saat anda meninqgalkannya?",
            "8.	Jangan menunjuk, membantu atau membetulkan, katakan pada anak : 'Tunjukkan segi empat merah'  'Tunjukkan segi empat kuning'  'Tunjukkan segi empat biru'  'Tunjukkan segi empat hijau'",
            "9.	Suruh anak melompat dengan satu kaki beberapa kali tanpa berpegangan (lompatan dengan dua kaki tidak ikut dinilai). Apakah ia dapat melompat 2-3 kali dengan satu kaki?",
            "10.Dapatkah anak sepenuhnya berpakaian sendiri tanpa bantuan?"




};

    public static int[] images = new int[] {
            R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_14_4, R.drawable.img_13_9, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_14_8, R.drawable.img_blank, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







