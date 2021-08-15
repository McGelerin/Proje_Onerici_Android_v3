package com.example.bitirme_projesiv3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjelerAdapter extends RecyclerView.Adapter<ProjelerAdapter.CardTassarımTutucu> {
    private Context mContext;
    private List<Projeler> projelerListe;

    public ProjelerAdapter(Context mContext, List<Projeler> projelerListe) {
        this.mContext = mContext;
        this.projelerListe = projelerListe;
    }

    @NonNull
    @Override
    public CardTassarımTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proje_card_tasarim,parent,false);
        return new CardTassarımTutucu(view);
    }


    //projeler satırını yazdırma
    @Override
    public void onBindViewHolder(@NonNull CardTassarımTutucu holder, int position) {
        Projeler proje = projelerListe.get(position);

        //Card yazdırma
        holder.textViewProjeAd.setText(proje.getProje_baslik());
        holder.imageViewProjeResim.setImageResource(mContext.getResources().getIdentifier(proje.getProje_resim()
                ,"drawable"
                ,mContext.getPackageName()));

        //Card tıklanınca
        holder.proje_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,DetayActivity.class);

                intent.putExtra("nesne",proje);

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return projelerListe.size();
    }

    public class CardTassarımTutucu extends RecyclerView.ViewHolder{
        private CardView proje_card;
        private TextView textViewProjeAd;
        private ImageView imageViewProjeResim;

        public CardTassarımTutucu(@NonNull View itemView) {
            super(itemView);

            proje_card = itemView.findViewById(R.id.proje_card);
            textViewProjeAd = itemView.findViewById(R.id.textViewProjeAd);
            imageViewProjeResim = itemView.findViewById(R.id.imageViewResim);
        }
    }
}
