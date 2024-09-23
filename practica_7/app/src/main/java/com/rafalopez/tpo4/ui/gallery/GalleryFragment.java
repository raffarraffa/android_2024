package com.rafalopez.tpo4.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;
import com.rafalopez.tpo4.R;
import com.rafalopez.tpo4.databinding.FragmentGalleryBinding;



public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel mv = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mv.getMapaActual().observe(getViewLifecycleOwner(), new Observer<GalleryViewModel.MapaActual>() {
            @Override
            public void onChanged(GalleryViewModel.MapaActual mapaActual) {

                 SupportMapFragment mapFragment =
                            (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
                    if (mapFragment != null) {
                        mapFragment.getMapAsync(mapaActual);
                    }
            }
        });
        mv.obtenerMapa();

        return root;
    }
}


//public class GalleryFragment extends FragmentActivity {
//    private GalleryViewModel mv;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mv =
//                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(GalleryViewModel.class);
//        mv.getMapaActual().observe(this, new Observer<GalleryViewModel.MapaActual>() {
//            @Override
//            public void onChanged(GalleryViewModel.MapaActual mapaActual) {
//                ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
//            }
//        });
//        mv.obtenerMapa();
//    }
//
//
//
//}