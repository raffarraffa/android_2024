package com.rafalopez.tpo4.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafalopez.tpo4.R;
import com.rafalopez.tpo4.entity.Farmacia;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    public ArrayList<Farmacia> farmacias;
    private LayoutInflater li;
    public ItemAdapter(ArrayList<Farmacia> farmacias, LayoutInflater li) {
        this.farmacias = farmacias;
        this.li=li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Farmacia farmacia = farmacias.get(position);
        holder.titleFarmacia.setText(farmacia.getTitle());
        holder.dirFarmacia.setText(farmacia.getDir());
    }

    @Override
    public int getItemCount() {
        return farmacias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleFarmacia;
        TextView dirFarmacia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleFarmacia = itemView.findViewById(R.id.titleFarmacia);
            dirFarmacia = itemView.findViewById(R.id.dirFarmacia);
        }
    }
}
