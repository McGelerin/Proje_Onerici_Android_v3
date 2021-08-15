package com.example.bitirme_projesiv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class ProjelerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView projelerRv;
    private ArrayList<Projeler> projelerArrayList;
    private ProjelerAdapter adapter;
    private Kategoriler kategori;
    private Veritabani vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeler);
        vt = new Veritabani(this);
        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbar = findViewById(R.id.toolbar);
        projelerRv = findViewById(R.id.projelerRv);

        toolbar.setTitle(kategori.getKategori_ad()); //değişecek
        setSupportActionBar(toolbar);




        projelerArrayList = new ProjelerDao().tumProjelerByKategoriId(vt,kategori.getKategori_id());

                //Cardın gözükme ayarları
        projelerRv.setHasFixedSize(true);
        projelerRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


        //test
        /*projelerArrayList = new ArrayList<>();
        Projeler p1 = new Projeler(1,"gelecek","buuuu kısım gözükmeyecek","afis1",null,null);
        Projeler p2 = new Projeler(1,"gelecekği tasarla","buuuu kısım gözükmeyecek","afis2",null,null);

        projelerArrayList.add(p1);
        projelerArrayList.add(p2);*/


        adapter = new ProjelerAdapter(this,projelerArrayList);
        projelerRv.setAdapter(adapter);
    }
}