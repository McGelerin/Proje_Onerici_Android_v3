package com.example.bitirme_projesiv3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(@Nullable Context context) {
        super(context,"projeler.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Kullanıcı tablosu
        db.execSQL("CREATE TABLE IF NOT EXISTS \"kullanici\" (\n" +
                "\t\"kullanici_id\"\tINTEGER,\n" +
                "\t\"kullanici_ad\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"kullanici_id\" AUTOINCREMENT)\n" +
                ");");
        //kategori
        db.execSQL("CREATE TABLE IF NOT EXISTS \"kategori\" (\n" +
                "\t\"kategori_id\"\tINTEGER,\n" +
                "\t\"kategori_ad\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"kategori_id\" AUTOINCREMENT)\n" +
                ");");
        //proje
        db.execSQL("CREATE TABLE IF NOT EXISTS \"proje\" (\n" +
                "\t\"proje_id\"\tINTEGER,\n" +
                "\t\"proje_baslik\"\tTEXT,\n" +
                "\t\"proje_icerik\"\tTEXT,\n" +
                "\t\"proje_resim\"\tTEXT,\n" +
                "\t\"kategori_id\"\tINTEGER,\n" +
                "\t\"kullanici_id\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"proje_id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"kullanici_id\") REFERENCES \"kullanici\"(\"kullanici_id\"),\n" +
                "\tFOREIGN KEY(\"kategori_id\") REFERENCES \"kategori\"(\"kategori_id\")\n" +
                ");");
        //begeni
        db.execSQL("CREATE TABLE IF NOT EXISTS \"begeni\" (\n" +
                "\t\"begeni_id\"\tINTEGER,\n" +
                "\t\"proje_id\"\tINTEGER,\n" +
                "\t\"kullanici_id\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"begeni_id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"kullanici_id\") REFERENCES \"kullanici\"(\"kullanici_id\"),\n" +
                "\tFOREIGN KEY(\"proje_id\") REFERENCES \"proje\"(\"proje_id\")\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kullanici");
        db.execSQL("DROP TABLE IF EXISTS kategori");
        db.execSQL("DROP TABLE IF EXISTS proje");
        db.execSQL("DROP TABLE IF EXISTS begeni");
        onCreate(db);

    }
}
