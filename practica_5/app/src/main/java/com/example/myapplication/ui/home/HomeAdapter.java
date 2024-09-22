package com.example.myapplication.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.time.format.TextStyle;
import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private ArrayList<String> lista;
private  LayoutInflater li;
    public HomeAdapter(ArrayList<String> lista, LayoutInflater li) {
        this.lista = lista;
        this.li=li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView itemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText=itemView.findViewById(R.id.itemText);
        }
    }
}
