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

public class KPSP6BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp6_bulan);

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

                    if (mQuestionsnumber == Questions1.mQuestions.length) {
                        Intent i = new Intent(KPSP6BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP6BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions1.mQuestions.length) {
                        Intent i = new Intent(KPSP6BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP6BULAN.this.finish();
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

                    if (mQuestionsnumber == Questions1.mQuestions.length) {
                        Intent i = new Intent(KPSP6BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP6BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions1.mQuestions.length) {
                        Intent i = new Intent(KPSP6BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP6BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        imageView.setImageResource(Questions1.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions1.mQuestions[mQuestionsnumber]);
        mAnswer = Questions1.answers[mQuestionsnumber];
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP6BULAN.this);
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

class Questions1 {
    public static String mQuestions [] =  new String[]{
            "1.	Pada waktu bayi telentang, apakah ia dapat mengikuti gerakan anda dengan menggerakkan kepala sepenuhnya dari satu sisi ke sisi yang lain?",
            "2.	Dapatkah bayi mempertahankan posisi kepala dalam keadaan tegak dan stabil? Jawab TIDAK bila kepala bayi cenderung jatuh ke kanan/kiri atau ke dadanya",
            "3.	Sentuhkan pensil di punggung tangan atau ujung jari bayi.\n (jangan meletakkan di atas telapak tangan bayi). Apakah bayi dapat menggenggam pensil itu selama beberapa detik?",
            "4.	Ketika bayi telungkup di alas datar, apakah ia dapat mengangkat dada dengan kedua lengannya sebagai penyangga seperti padA gambar ?",
            "5.	Pernahkah bayi mengeluarkan suara gembira bernada tinggi atau memekik tetapi bukan menangis?",
            "6.	Pernahkah bayi berbalik paling sedikit dua kali, dari telentang ke telungkup atau sebaliknya?",
            "7.	Pernahkah anda melihat bayi tersenyurn ketika melihat mainan yang lucu, gambar atau binatang peliharaan pada saat ia bermain sendiri?",
            "8.	Dapatkah bayi mengarahkan matanya pada benda kecil sebesar kacang, kismis atau uang logam? Jawab TIDAK jika ia tidak dapat mengarahkan matanya.",
            "9.	Dapatkah bayi meraih mainan yang diletakkan agak jauh namun masih berada dalam jangkauan tangannya?",
            "10. Pada posisi bayi telentang, pegang kedua tangannya lalu tarik perlahan-lahan ke posisi clucluk. Dapatkah bayi mempertahankan lehernya secara kaku seperti gambar di sebelah kiri ? Jawab TIDAK bila kepala bayi jatuh kembali"


};

    public static int[] images = new int[] {
            R.drawable.img_2_1, R.drawable.img_blank, R.drawable.img_2_3, R.drawable.img_2_4, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_2_10
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







