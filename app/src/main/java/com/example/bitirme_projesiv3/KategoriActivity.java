package com.example.bitirme_projesiv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class KategoriActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView kategoriRv;
    private ArrayList<Kategoriler>kategorilerArrayList;
    private KategoriAdapter adapter;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        toolbar = findViewById(R.id.toolbar);
        kategoriRv = findViewById(R.id.kategoriRv);

        veritabaniKopyala();
        vt = new Veritabani(this);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        //rv için tasarım kısmı

        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDao().tumKategoriler(vt);

        /*
        // Test
        Kategoriler k1= new Kategoriler(1,"Bilgisayar");
        Kategoriler k2= new Kategoriler(2,"Çevre");

        kategorilerArrayList.add(k1);
        kategorilerArrayList.add(k2);
*/
        adapter = new KategoriAdapter(this,kategorilerArrayList);
        kategoriRv.setAdapter(adapter);
    }

    public void veritabaniKopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}