package com.example.bitirme_projesiv3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProjelerDao {
    public ArrayList<Projeler> tumProjelerByKategoriId(Veritabani vt,int kategori_id){
        ArrayList<Projeler> projelerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();


        //Satır satır veri alma
        Cursor c = db.rawQuery("SELECT * FROM kategori,proje,kullanici WHERE proje.kategori_id = kategori.kategori_id and proje.kullanici_id = kullanici.kullanici_id and proje.kategori_id="+kategori_id,null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id"))
                    ,c.getString(c.getColumnIndex("kategori_ad")));

            Kullanicilar k2 = new Kullanicilar(c.getInt(c.getColumnIndex("kullanici_id"))
                    ,c.getString(c.getColumnIndex("kullanici_ad")));

            Projeler p = new Projeler(c.getInt(c.getColumnIndex("proje_id"))
                    ,c.getString(c.getColumnIndex("proje_baslik"))
                    ,c.getString(c.getColumnIndex("proje_icerik"))
                    ,c.getString(c.getColumnIndex("proje_resim"))
                    ,k,k2);

            projelerArrayList.add(p);
        }
        return projelerArrayList;
    }
}