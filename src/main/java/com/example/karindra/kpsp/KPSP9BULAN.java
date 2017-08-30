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

public class KPSP9BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp9_bulan);

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

                    if (mQuestionsnumber == Questions2.mQuestions.length) {
                        Intent i = new Intent(KPSP9BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP9BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions2.mQuestions.length) {
                        Intent i = new Intent(KPSP9BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP9BULAN.this.finish();
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

                    if (mQuestionsnumber == Questions2.mQuestions.length) {
                        Intent i = new Intent(KPSP9BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP9BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions2.mQuestions.length) {
                        Intent i = new Intent(KPSP9BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP9BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        imageView.setImageResource(Questions2.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions2.mQuestions[mQuestionsnumber]);
        mAnswer = Questions2.answers[mQuestionsnumber];
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP9BULAN.this);
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

class Questions2 {
    public static String mQuestions [] =  new String[]{
            "1.	Pada posisi bayi telentang, pegang kedua tangannya lalu tarik perlahan-lahan ke posisi duduk. Dapatkah bayi mempertahankan lehernya secara kaku seperti gambar di sebelah kiri ? Jawab TIDAK bila kepala bayi jatuh kembali.",
            "2.	Pernahkah anda melihat bayi memindahkan mainan atau kue kering dari satu tangan ke tangan yang lain? Benda?benda panjang seperti sendok atau kerincingan bertangkai tidak ikut dinilai.",
            "3.	Tarik perhatian bayi dengan memperlihatkan selendang, sapu tangan atau serbet, kemudian jatuhkan ke lantai. Apakah bayi mencoba mencarinya? Misalnya mencari di bawah meja atau di belakang kursi?",
            "4.	Apakah bayi dapat memungut dua benda seperti mainan/kue kering, dan masing-masing tangan memegang satu benda pada saat yang sama? Jawab TIDAK bila bayi tidak pernah melakukan perbuatan ini.",
            "5.	Jika anda mengangkat bayi melalui ketiaknya ke posisi berdiri, dapatkah ia menyangga sebagian berat badan dengan kedua kakinya? Jawab YA bila ia mencoba berdiri dan sebagian berat badan tertumpu pada kedua kakinya.",
            "6.	Dapatkah bayi memungut dengan tangannya benda-benda kecil seperti kismis, kacang?kacangan, potongan biskuit, dengan gerakan miring atau menggerapai seperti gambar ?",
            "7.	Tanpa disangga oleh bantal, kursi atau dinding, dapatkah bayi duduk sendiri selama 60 detik?",
            "8.	Apakah bayi dapat makan kue kering sendiri?",
            "9.	Pada waktu bayi bermain sendiri dan anda diam-diam datang berdiri di belakangnya, apakah ia menengok ke belakang seperti mendengar kedatangan anda? Suara keras tidak ikut dihitung. Jawab YA hanya jika anda melihat reaksinya terhadap suara yang perlahan atau bisikan.",
            "10. Letakkan suatu mainan yang dinginkannya di luar jangkauan bayi, apakah ia mencoba mendapatkannya dengan mengulurkan lengan atau badannya?"



    };

    public static int[] images = new int[] {
            R.drawable.img_3_1, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_3_6, R.drawable.img_3_7, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







