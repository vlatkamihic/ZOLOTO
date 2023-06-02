package com.example.zoloto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PKamenjeAdapter extends RecyclerView.Adapter<PKamenjeAdapter.PKamenjeHolder>{

    String datanPK[], datasPK[];
    int slikePK[];
    Context context;

    public PKamenjeAdapter(Context ct, String nPK[], String sPK[], int slPK[]){
        datanPK = nPK;
        datasPK = sPK;
        slikePK = slPK;
        context = ct;
    }

    @NonNull
    @Override
    public PKamenjeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View cellView = inflater.inflate(R.layout.pkamenje_cell, parent, false);
        return new PKamenjeAdapter.PKamenjeHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull PKamenjeHolder holder, int position) {
        holder.naslovi.setText(datanPK[position]);
        holder.opisi.setText(datasPK[position]);
        holder.slike.setImageResource(slikePK[position]);
    }

    @Override
    public int getItemCount() {
        return slikePK.length;
    }

    public class PKamenjeHolder extends RecyclerView.ViewHolder{

        TextView naslovi, opisi;
        ImageView slike;

        public PKamenjeHolder(@NonNull View itemView) {
            super(itemView);
            naslovi = itemView.findViewById(R.id.naslovPKamenja);
            opisi = itemView.findViewById(R.id.textPKamenja);
            slike = itemView.findViewById(R.id.slikaPKamenja);
        }
    }
}
