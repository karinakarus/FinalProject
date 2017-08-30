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

public class KPSP21BULAN extends AppCompatActivity {
    private Button btnYA, btnTIDAK;
    private TextView txtPertanyaan, score;
    private ImageView imageView;
    private boolean mAnswer ;
    private int mScore=0;
    private int mQuestionsnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp21_bulan);

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

                    if (mQuestionsnumber == Questions6.mQuestions.length) {
                        Intent i = new Intent(KPSP21BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP21BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions6.mQuestions.length) {
                        Intent i = new Intent(KPSP21BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP21BULAN.this.finish();
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

                    if (mQuestionsnumber == Questions6.mQuestions.length) {
                        Intent i = new Intent(KPSP21BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP21BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionsnumber == Questions6.mQuestions.length) {
                        Intent i = new Intent(KPSP21BULAN.this, Activity_RincialHasil.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        KPSP21BULAN.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        imageView.setImageResource(Questions6.images[mQuestionsnumber]);
        txtPertanyaan.setText(Questions6.mQuestions[mQuestionsnumber]);
        mAnswer = Questions6.answers[mQuestionsnumber];
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
        AlertDialog.Builder builder = new AlertDialog.Builder(KPSP21BULAN.this);
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

class Questions6 {
    public static String mQuestions [] =  new String[]{
            "1.	Tanpa berpegangan atau menyentuh lantai, apakah anak dapat membungkuk untuk memungut mainan di lantai dan kemudian berdiri kembali?",
            "2.	Apakah anak dapat menunjukkan apa yang diinginkannya tanpa menangis atau merengek? Jawab YA bila ia menunjuk, menarik atau mengeluarkan suara yang menyenangkan.",
            "3.	Apakah anak dapat berjalan di sepanjang ruangan tanpa jatuh atau terhuyung-huyung?",
            "4.	Apakah anak dapat mengambil benda kecil seperti kacang, kismis, atau potongan biskuit dengan menggunakan ibu jari dan jari telunjuk seperti pada gambar ?",
            "5.	Jika anda menggelindingkan bola ke anak, apakah ia menggelindingkan/melemparkan kembali bola pada anda?",
            "6.	Apakah anak dapat memegang sendiri cangkir/gelas dan minum dari tempat tersebut tanpa tumpah?",
            "7.	Jika anda sedang melakukan pekerjaan rumah tangga, apakah anak meniru apa yang anda lakukan?",
            "8.	Apakah anak dapat meletakkan satu kubus di atas Gerak halus Ya Tida kubus yang lain tanpa menjatuhkan kubus itu? Kubus yang digunakan ukuran 2.5-5.0 cm",
            "9.	Apakah anak dapat mengucapkan paling sedikit 3 kata yang mempunyai arti selain “papa” dan “mama”?.",
            "10.Apakah anak dapat berjalan mundur 5 langkah atau lebih tanpa kehilangan keseimbangan? (Anda mungkin dapat melihatnya ketika anak menarik mainannya)"






};

    public static int[] images = new int[] {
            R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_7_4, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank, R.drawable.img_blank
    };

    public static boolean[] answers = new boolean[] {
            true, true, true, true, true,true, true, true, true, true
    };



}







