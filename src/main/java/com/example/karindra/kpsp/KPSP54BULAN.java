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

public class KPSP54BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp54_bulan);

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
                        Intent i = new Intent(KPSP54BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP54BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP54BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP54BULAN.this.finish();
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
                        Intent i = new Intent(KPSP54BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP54BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions15.mQuestions.length) {
                        Intent i = new Intent(KPSP54BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP54BULAN.this.finish();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP54BULAN.this);
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

class Questions12 {
    public static String mQuestions [] =  new String[]{
            "1.	Dapatkah anak meletakkan 8 buah kubus satu persatu di atas yang lain tanpa menjatuhkan kubus tersebut? Kubus yang digunakan ukuran 2-5 – 5 cm. ",
            "2.	Apakah anak dapat bermain petak umpet, ular naga atau permainan lain dimana ia ikut bermain dan mengikuti aturan bermain?",
            "3.	Dapatkah anak mengenakan celana panjang, kemeja, baju atau kaos kaki tanpa di bantu? (Tidak termasuk memasang kancing, gesper atau ikat pinggang)",
            "4.	Dapatkah anak menyebutkan nama lengkapnya tanpa dibantu? Jawab TIDAK jika ia hanya menyebut sebagian namanya atau ucapannya sulit dimengerti.",
            "5.	Isi titik-titik di bawah ini dengan jawaban anak. Jangan membantu kecuali mengulangi pertanyaan.  'Apa yang kamu lakukan jika kamu kedinginan?'  'Apa yang kamu lakukan jika kamu lapar?'  'Apa yang kamu lakukan jika kamu lelah?'  Jawab YA biia anak merjawab ke 3 pertanyaan tadi dengan benar, bukan dengan gerakan atau isyarat.",
            "6.	Apakah anak dapat mengancingkan bajunya atau pakaian boneka?",
            "7.	Suruh anak berdiri satu kaki tanpa berpegangan. Jika perlu tunjukkan caranya dan beri anak ands kesempatan melakukannya 3 kali. Dapatkah ia mempertahankan keseimbangan dalam waktu 6 detik atau lebih?",
            "8.	Jangan mengoreksi/membantu anak. Jangan menyebut kata 'lebih panjang'. Terlihatkan gambar kedua garis ini pada anak. Tanyakan: 'Mana garis yang lebih panjang?'  Minta anak menunjuk garis yang lebih panjang.  Apakah anak dapat menunjuk garis yang lebih panjang sebanyak 3 kali dengan benar?",
            "9.	Jangan membantu anak dan jangan memberitahu nama gambar ini, suruh anak menggambar seperti contoh ini di kertas kosong yang tersedia. Berikan 3 kali kesempatan. Apakah anak dapat menggambar seperti contoh ini?",
            "10.Ikuti perintah ini dengan seksama. Jangan memberi isyarat dengan telunjuk atau mats pads saat memberikan perintah berikut ini: 'Letakkan kertas ini di atas lantai'.  'Letakkan kertas ini di bawah kursi'.  'Letakkan kertas ini di depan kamu'  'Letakkan kertas ini di belakang kamu'  Jawab YA hanya jika anak mengerti arti di atas,di bawah,di depan dandi belakang.",




};

    public static int[] images = new int[] {
            R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_13_8, R.drawable.img_13_9, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







