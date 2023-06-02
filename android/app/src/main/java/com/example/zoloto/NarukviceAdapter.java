package com.example.zoloto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NarukviceAdapter extends RecyclerView.Adapter<NarukviceAdapter.NarukviceHolder> {

    String datanN[], datasN[];
    int slikeN[];
    Context context;

    public NarukviceAdapter(Context ct, String nN[], String sN[], int slN[]){
        datanN = nN;
        datasN = sN;
        slikeN = slN;
        context = ct;
    }

    @NonNull
    @Override
    public NarukviceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View cellView = inflater.inflate(R.layout.narukvice_cell, parent, false);
        return new NarukviceHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull NarukviceHolder holder, int position) {
        holder.naslovi.setText(datanN[position]);
        holder.opisi.setText(datasN[position]);
        holder.slike.setImageResource(slikeN[position]);
    }

    @Override
    public int getItemCount() {
        return slikeN.length;
    }

    public class NarukviceHolder extends RecyclerView.ViewHolder{

        TextView naslovi, opisi;
        ImageView slike;

        public NarukviceHolder(@NonNull View itemView) {
            super(itemView);
            naslovi = itemView.findViewById(R.id.naslovNarukvice);
            opisi = itemView.findViewById(R.id.textNarukvice);
            slike = itemView.findViewById(R.id.slikaNarukvice);
        }
    }
}
