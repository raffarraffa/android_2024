package com.rafalopez.tpo4.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;
import com.rafalopez.tpo4.R;

public class GalleryFragment extends FragmentActivity {
    private GalleryViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(GalleryViewModel.class);
        mv.getMapaActual().observe(this, new Observer<GalleryViewModel.MapaActual>() {
            @Override
            public void onChanged(GalleryViewModel.MapaActual mapaActual) {
                ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
            }
        });
        mv.obtenerMapa();
    }



}