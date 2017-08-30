package com.example.karindra.kpsp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karindra on 14/08/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String NAMA_DATABASE = "kpsp.db";
    private static final int VERSI_DATABASE = 1;
    private static final String TABLE_DATAANAK = "data_anak";


    //FIELDS TABEL data_anak
    public static final String ROW_ID = "id_anak";
    public static final String ROW_NAMA = "nama_anak";
    public static final String ROW_TANGGALLAHIR = "tgl_lhr";
    public static final String ROW_UMUR = "umur";
    public static final String ROW_BERATBADAN = "berat_badan";
    public static final String ROW_HASIL = "hasil";



    private String[] Fields_dataanak = {DataHelper.ROW_ID, DataHelper.ROW_NAMA, DataHelper.ROW_TANGGALLAHIR, DataHelper.ROW_UMUR, DataHelper.ROW_BERATBADAN};

    public DataHelper(Context context) {
        super(context, NAMA_DATABASE, null, VERSI_DATABASE);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_DATAANAK = "CREATE TABLE " + TABLE_DATAANAK + " (" + ROW_ID + " INTEGER PRIMARY KEY, " + ROW_NAMA + " TEXT, " + ROW_TANGGALLAHIR + " TEXT, " + ROW_UMUR + " TEXT, " + ROW_BERATBADAN + " TEXT, " + ROW_HASIL + " TEXT );";
        db.execSQL(CREATE_TABLE_DATAANAK);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_DATAANAK);
        onCreate(db);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //TABLE DATA_ANAK .... METHOD SIMPAN KE SQLITE
    public void saveData_Anak(data_anak dataanak) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataHelper.ROW_ID, dataanak.getId_Anak());
        values.put(DataHelper.ROW_NAMA, dataanak.getNama_anak());
        values.put(DataHelper.ROW_TANGGALLAHIR, dataanak.getTgl_lhr());
        values.put(DataHelper.ROW_UMUR, dataanak.getUmur());
        values.put(DataHelper.ROW_BERATBADAN, dataanak.getBerat_badan());
        values.put(DataHelper.ROW_HASIL, dataanak.getHasil());
        db.insert(TABLE_DATAANAK, null, values);
        db.close();
    }

    //TABLE DATA_ANAK ..... MENGAMBIL SEMUA DATA

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DATAANAK;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    // MENGAMBIL DATA BERDASARKAN ID /////////////

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + ROW_ID + " FROM " + TABLE_DATAANAK +
                " WHERE " + ROW_NAMA + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }




    //TABEL DATA_ANAK ...... HAPUS DATA
    public void delete(data_anak dataanak){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_DATAANAK, ROW_ID+"=?", new String[]{String.valueOf(dataanak.getId_Anak())});
        db.close();
    }


}