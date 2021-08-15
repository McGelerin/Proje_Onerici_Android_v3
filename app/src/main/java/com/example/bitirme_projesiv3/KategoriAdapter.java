package com.example.bitirme_projesiv3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTassarımTutucu> {
    private Context mContext;
    private List<Kategoriler> kategorilerListe;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerListe) {
        this.mContext = mContext;
        this.kategorilerListe = kategorilerListe;
    }

    @NonNull
    @Override
    public CardTassarımTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card_tasarim,parent,false);
        return new CardTassarımTutucu(view);
    }


    //kategorilerin satırını yazdırma
    @Override
    public void onBindViewHolder(@NonNull CardTassarımTutucu holder, int position) {
        Kategoriler kategori = kategorilerListe.get(position);
        //card a erişme
        holder.textViewKategoriAd.setText(kategori.getKategori_ad());

        //carda tıklayınca
        holder.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ProjelerActivity.class);

                intent.putExtra("kategori_nesne",kategori);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return kategorilerListe.size();
    }

    public class CardTassarımTutucu extends RecyclerView.ViewHolder{
        private CardView kategori_card;
        private TextView textViewKategoriAd;

        public CardTassarımTutucu(@NonNull View itemView) {
            super(itemView);

            kategori_card = itemView.findViewById(R.id.kategori_card);
            textViewKategoriAd = itemView.findViewById(R.id.textViewKategoriAd);
        }
    }
}
