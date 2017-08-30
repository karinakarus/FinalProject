package com.example.karindra.kpsp;

/**
 * Created by Karindra on 03/08/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class Activity_InputData extends AppCompatActivity {

    int mYear, mMonth, mDay;
    protected Cursor cursor;
    public static final String PREFS = "Activity_InputData.KEY";
    static final int DATE_DIALOG_ID = 1;
    private String[] arrMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    Button btnHitungUmur, btnSimpan, btnKeluar;
    EditText edtTglLahir, edtNamaAnak, edtBeratBadan, edtNomor, edtUmur;
    DataHelper dataHelper;
    String[] daftar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_inputdatabaru);

        dataHelper = new DataHelper(this);
        edtNamaAnak = (EditText) findViewById(R.id.edtNamaAnak);
        edtBeratBadan = (EditText) findViewById(R.id.edtBeratBadan);
        edtUmur = (EditText) findViewById(R.id.edtUmur);
        edtNomor = (EditText)findViewById(R.id.edtNomor);
        btnHitungUmur = (Button) findViewById(R.id.btnHitungUmur);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity_InputData.this.finish();
            }
        });

/////////////////////////////// SIMPAN DATA DENGAN SHAREDPREFERENCES, LALU MASUK KE ACTIVITY PILIH UMUR ///////////////////////////////////////////

        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String No = edtNomor.getText().toString();
                String Nama = edtNamaAnak.getText().toString();
                String Tgl = edtTglLahir.getText().toString();
                String Umur = edtUmur.getText().toString();
                String Berat = edtBeratBadan.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("dataNo", No);
                editor.putString("dataNama", Nama);
                editor.putString("dataTgl", Tgl);
                editor.putString("dataUmur", Umur);
                editor.putString("dataBerat", Berat);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Activity_PilihUmur.class);
                startActivity(intent);

            }

        });

/////////////////////////////// MENGHITUNG UMUR DARI DATETIME PICKER /////////////////////////////////////////////////////////

        btnHitungUmur.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Calendar now=  Calendar.getInstance();
                Calendar tanggallahir = Calendar.getInstance();
                tanggallahir.set(mYear, mMonth, mDay);
                int years = now.get(Calendar.YEAR) - tanggallahir.get(Calendar.YEAR);
                int months = now.get(Calendar.MONTH) - tanggallahir.get(Calendar.MONTH);
                int days = now.get(Calendar.DAY_OF_MONTH) - tanggallahir.get(Calendar.DAY_OF_MONTH);
                if (days < 0){
                    months --;
                    days +=now.getActualMaximum(Calendar.DAY_OF_MONTH);
                }
                if (months < 0){
                    years --;
                    months +=12;
                }
                String umur = years+" tahun "+months+ " bulan "+days+" hari";
                edtUmur.setText(umur);
            }
        });

///////////////////////////////////////AMBIL TGL HARI INI /////////////////////////////////////////////////////////////////////////////////////

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        edtTglLahir = (EditText) findViewById(R.id.edtTglLahir);
        edtTglLahir.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });

    }

//////////////////////////////////////// REFRESH LIST DATA ANAK DI DATABASE SQLITE /////////////////////////////////////////////////////////////

    public void RefreshList() {
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM data_anak", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String sdate = LPad(mDay + "  ", "0", 2) + arrMonth[mMonth] + "  "   + ", " + mYear;
            edtTglLahir.setText(sdate);
        }
    };

    private static String LPad(String schar, String spad, int len) {
        String sret = schar;
        for (int i = sret.length(); i < len; i++) {
            sret = spad + sret;
        }
        return new String(sret);
    }

    }

