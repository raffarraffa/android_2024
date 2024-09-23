package com.rafalopez.tpo4.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafalopez.tpo4.R;
import com.rafalopez.tpo4.databinding.FragmentDetailBinding;
import com.rafalopez.tpo4.databinding.FragmentGalleryBinding;
import com.rafalopez.tpo4.entity.Farmacia;

public class DetailFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDetailBinding binding;
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        DetailViewModel mv;
        mv = new ViewModelProvider(this).get(DetailViewModel.class);
        mv.getFarmacia().observe(getViewLifecycleOwner(), new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {
                binding.titleFarmacia.setText("Farmacia: " + farmacia.getTitle());
                binding.dirFarmacia.setText("Direccion: "+ farmacia.getDir());
                binding.timeFarmacia.setText("Horario: " + farmacia.getHorario());
                binding.imageView2.setImageResource(farmacia.getImg());
            }
        });
        mv.getDetailFarmacia(getArguments());
        return binding.getRoot();
    }
}