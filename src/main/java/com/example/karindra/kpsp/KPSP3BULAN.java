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

public class KPSP3BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_kpsp3_bulan);

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

                            if (mQuestionsnumber == Questions.mQuestions.length) {
                                Intent i = new Intent(KPSP3BULAN.this, Activity_RincialHasil.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", mScore);
                                i.putExtras(bundle);
                                KPSP3BULAN.this.finish();
                                startActivity(i);
                            } else {
                                updateQuestion();
                            }
                        } else {
                            if (mQuestionsnumber == Questions.mQuestions.length) {
                                Intent i = new Intent(KPSP3BULAN.this, Activity_RincialHasil.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", mScore);
                                i.putExtras(bundle);
                                KPSP3BULAN.this.finish();
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

                            if (mQuestionsnumber == Questions.mQuestions.length) {
                                Intent i = new Intent(KPSP3BULAN.this, Activity_RincialHasil.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", mScore);
                                i.putExtras(bundle);
                                KPSP3BULAN.this.finish();
                                startActivity(i);
                            } else {
                                updateQuestion();
                            }
                        } else {
                            if (mQuestionsnumber == Questions.mQuestions.length) {
                                Intent i = new Intent(KPSP3BULAN.this, Activity_RincialHasil.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("finalScore", mScore);
                                i.putExtras(bundle);
                                KPSP3BULAN.this.finish();
                                startActivity(i);
                            } else {
                                updateQuestion();
                            }
                        }
                    }
                });


            }



    private void updateQuestion() {
        imageView.setImageResource(Questions.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions.mQuestions[mQuestionsnumber]);
        mAnswer = Questions.answers[mQuestionsnumber];
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP3BULAN.this);
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

class Questions {
    public static String mQuestions [] =  new String[]{
            " 1. Pada waktu bayi telentang, apakah masing-masing lengan dan tungkai bergerak dengan mudah? Jawab TIDAK bila salah satu atau kedua tungkai atau lengan bayi bergerak tak terarah/tak terkendali",
            " 2. Pada waktu bayi telentang apakah ia melihat dan menatap wajah anda? ",
            " 3. Apakah bayi dapat mengeluarkan suara-suara lain (ngoceh), disamping menangis?",
            " 4. Pada waktu bayi telentang, apakah ia dapat mengikuti gerakan anda dengan menggerakkan kepalanya dari kanan/kiri ke tengah?",
            " 5. Pada waktu bayi telentang, apakah. ia dapat mengikuti gerakan anda dengan menggerakkan kepalanya dari satu sisi hampir sampai pada sisi yang lain? ",
            " 6. Pada waktu anda mengajak bayi berbicara dan tersenyum,apakah ia tersenyum kembali kepada anda? ",
            " 7. Pada waktu bayi telungkup di alas yang datar, apakah ia dapat mengangkat kepalanya seperti pada gambar ini?",
            " 8. Pada waktu bayi telungkup di alas yang datar, apakah ia dapat mengangkat kepalanya sehingga membentuk sudut 45 derajat? ",
            " 9. Pada waktu bayi telungkup di alas yang datar, apakah ia dapat mengangkat kepalanya dengan tegak seperti gambar? ",
            " 10. Apakah bayi suka tertawa keras walau tidak digelitik atau diraba-raba? "
    };

    public static int[] images = new int[] {
            R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_1_4, R.drawable.img_1_5, R.drawable.img_blank, R.drawable.img_1_7, R.drawable.img_1_8, R.drawable.img_1_9, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







