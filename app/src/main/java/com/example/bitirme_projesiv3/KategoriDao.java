package com.example.bitirme_projesiv3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {
    public ArrayList<Kategoriler> tumKategoriler(Veritabani vt){
        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();


        //Satır satır veri alma
        Cursor c = db.rawQuery("SELECT * FROM kategori",null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id"))
                    ,c.getString(c.getColumnIndex("kategori_ad")));

            kategorilerArrayList.add(k);
        }
        return kategorilerArrayList;
    }
}
