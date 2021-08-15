package com.example.bitirme_projesiv3;

import java.io.Serializable;

public class Kullanicilar implements Serializable {
    private int kullanici_id;
    private String kullanici_ad;

    public Kullanicilar() {
    }

    public Kullanicilar(int kullanici_id, String kullanici_ad) {
        this.kullanici_id = kullanici_id;
        this.kullanici_ad = kullanici_ad;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }
}
