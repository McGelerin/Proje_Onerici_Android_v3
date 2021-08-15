package com.example.bitirme_projesiv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class GirisActivity extends AppCompatActivity {

    private EditText editTextAd;
    private Button buttonGiris;
    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        //Tanımladıklarımızı bağlama
        editTextAd = findViewById(R.id.editTextAd);
        buttonGiris = findViewById(R.id.buttonGiris);
        vt = new Veritabani(this);

        buttonGiris.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String kayit_ad = editTextAd.getText().toString().trim();

                if(TextUtils.isEmpty(kayit_ad)){
                    Snackbar.make(v,"Adınızı Giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                new KullanicilarDao().kullaniciEkle(vt,kayit_ad);

                startActivity(new Intent(GirisActivity.this,KategoriActivity.class));
                finish();
            }
        });
    }
}