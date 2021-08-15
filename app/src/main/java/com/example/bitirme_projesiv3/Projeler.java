package com.example.bitirme_projesiv3;

import java.io.Serializable;

public class Projeler implements Serializable {
    private int proje_id;
    private String proje_baslik;
    private String proje_icerik;
    private String proje_resim;
    private Kategoriler kategori;
    private Kullanicilar kullanici;

    public Projeler() {
    }

    public Projeler(int proje_id, String proje_baslik, String proje_icerik, String proje_resim, Kategoriler kategori, Kullanicilar kullanici) {
        this.proje_id = proje_id;
        this.proje_baslik = proje_baslik;
        this.proje_icerik = proje_icerik;
        this.proje_resim = proje_resim;
        this.kategori = kategori;
        this.kullanici = kullanici;
    }


    public int getProje_id() {
        return proje_id;
    }

    public void setProje_id(int proje_id) {
        this.proje_id = proje_id;
    }

    public String getProje_baslik() {
        return proje_baslik;
    }

    public void setProje_baslik(String proje_baslik) {
        this.proje_baslik = proje_baslik;
    }

    public String getProje_icerik() {
        return proje_icerik;
    }

    public void setProje_icerik(String proje_icerik) {
        this.proje_icerik = proje_icerik;
    }

    public String getProje_resim() {
        return proje_resim;
    }

    public void setProje_resim(String proje_resim) {
        this.proje_resim = proje_resim;
    }

    public Kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(Kategoriler kategori) {
        this.kategori = kategori;
    }

    public Kullanicilar getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanicilar kullanici) {
        this.kullanici = kullanici;
    }
}
