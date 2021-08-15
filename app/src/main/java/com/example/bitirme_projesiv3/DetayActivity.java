package com.example.bitirme_projesiv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private ImageView imageViewProjeResim;
    private TextView textViewProjeAd,textViewProjeIcerik,textViewYazar;
    private Projeler proje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewProjeResim = findViewById(R.id.imageViewResim);
        textViewProjeAd = findViewById(R.id.textViewProjeAd);
        textViewProjeIcerik = findViewById(R.id.textViewProjeIcerik);
        textViewYazar = findViewById(R.id.textViewYazar);

        proje = (Projeler) getIntent().getSerializableExtra("nesne");

        textViewProjeAd.setText(proje.getProje_baslik());
        textViewProjeIcerik.setText(proje.getProje_icerik());
        textViewYazar.setText(proje.getKullanici().getKullanici_ad());

        imageViewProjeResim.setImageResource(getResources().getIdentifier(proje.getProje_resim()
                ,"drawable"
                ,getPackageName()));
    }
}