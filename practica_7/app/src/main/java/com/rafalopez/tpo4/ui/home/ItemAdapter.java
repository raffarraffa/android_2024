package com.rafalopez.tpo4.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
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
        //DetailViewModel dVm =       new ViewModelProvider((FragmentActivity) context).get(DetailViewModel.class);

        Farmacia farmacia = farmacias.get(position);
        holder.titleFarmacia.setText(farmacia.getTitle());
        holder.dirFarmacia.setText(farmacia.getDir());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("farmacia",farmacia);
              Navigation.findNavController(v).navigate(R.id.action_nav_home_to_detailFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return farmacias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleFarmacia;
        TextView dirFarmacia;
        Button btnDetail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleFarmacia = itemView.findViewById(R.id.titleFarmacia);
            dirFarmacia = itemView.findViewById(R.id.dirFarmacia);
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }
    }
}
