package com.rafalopez.tpo4.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;
import com.rafalopez.tpo4.R;
import com.rafalopez.tpo4.databinding.FragmentGalleryBinding;

public class GalleryFragment extends FragmentActivity {
    private GalleryViewModel mv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getMapaActual().observe(this, new Observer<mv.MapaActual>() {
            @Override
            public void onChanged(mvtivityViewModel.MapaActual mapaActual) {
                ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
            }
        });
        mv.obtenerMapa(); // opcion llamr map desde main activity
    }



}