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

public class KPSP36BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp36_bulan);

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

                    if (mQuestionsnumber == Questions9.mQuestions.length) {
                        Intent i = new Intent(KPSP36BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP36BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions9.mQuestions.length) {
                        Intent i = new Intent(KPSP36BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP36BULAN.this.finish();
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

                    if (mQuestionsnumber == Questions9.mQuestions.length) {
                        Intent i = new Intent(KPSP36BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP36BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions9.mQuestions.length) {
                        Intent i = new Intent(KPSP36BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP36BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        imageView.setImageResource(Questions9.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions9.mQuestions[mQuestionsnumber]);
        mAnswer = Questions9.answers[mQuestionsnumber];
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP36BULAN.this);
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

class Questions9 {
    public static String mQuestions [] =  new String[]{
            "1.	Bila diberi pensil, apakah anak mencoret-coret kertas tanpa bantuan/petunjuk?",
            "2.	Dapatkah anak meletakkan 4 buah kubus satu persatu di atas kubus yang lain tanpa menjatuhkan kubus itu? Kubus yang digunakan ukuran 2.5 – 5 cm.",
            "3.	Dapatkah anak menggunakan 2 kata pada saat berbicara seperti “minta minum”; “mau tidur”? “Terimakasih” dan “Dadag” tidak ikut dinilai.",
            "4.	Apakah anak dapat menyebut 2 diantara gambar-gambar ini tanpa bantuan?",
            "5.	Dapatkah anak melempar bola lurus ke arah perut atau dada anda dari jarak 1,5 meter?",
            "6.	Ikuti perintah ini dengan seksama. Jangan memberi isyarat dengan telunjuk atau mata pada saat memberikan perintah berikut ini: “Letakkan kertas ini di lantai”. “Letakkan kertas ini di kursi”. “Berikan kertas ini kepada ibu”. Dapatkah anak melaksanakan ketiga perintah tadi?",
            "7.	Buat garis lurus ke bawah sepanjang sekurangkurangnya 2.5 cm. Suruh anak menggambar garis lain disamping garis tsb.",
            "8.	Letakkan selembar kertas seukuran buku di lantai. Apakah anak dapat melompati bagian lebar kertas dengan mengangkat kedua kakinya secara bersamaan tanpa didahului lari?",
            "9.	Dapatkah anak mengenakan sepatunya sendiri?",
            "10.Dapatkah anak mengayuh sepeda roda tiga sejauh sedikitnya 3 meter?"


};

    public static int[] images = new int[] {
            R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_10_4, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_10_7, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







