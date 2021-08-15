package com.example.bitirme_projesiv3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KullanicilarDao {
    public ArrayList<Kullanicilar> tumKullanicilar(Veritabani vt){
        ArrayList<Kullanicilar> kullanicilarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c= db.rawQuery("SELECT * FROM kullanici",null);

        while (c.moveToNext()){
            //BUrada ID ye bakmak lazım
            Kullanicilar k = new Kullanicilar(c.getInt(c.getColumnIndex("kullanici_id"))
                    ,c.getString(c.getColumnIndex("kullanici_ad")));
            kullanicilarArrayList.add(k);
        }
        //db.close();
        return kullanicilarArrayList;
    }

    public void kullaniciEkle(Veritabani vt,String kullanici_ad){
        SQLiteDatabase dbx = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("kullanici_ad",kullanici_ad);
        dbx.insertOrThrow("kullanici",null,values);
        dbx.close();

    }
}
