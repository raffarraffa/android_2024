package com.rafalopez.tpo4.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rafalopez.tpo4.MainActivity;
import com.rafalopez.tpo4.entity.Farmacia;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    private  MutableLiveData<MapaActual> mMapaActual;


    public GalleryViewModel(@NonNull Application application, ArrayList<Farmacia> farmacias) {
        super(application);

    }
    public LiveData<MapaActual> getMapaActual() {
        if (mMapaActual == null) {
            mMapaActual = new MutableLiveData<>();
            // obtenerMapa(); // opicon de llamar mapa en el livedata
        }
        return mMapaActual;
    }
    public  void obtenerMapa(){
        MapaActual mapaActual = new MapaActual();
        mMapaActual.setValue(mapaActual);
    }

    public class MapaActual implements OnMapReadyCallback {
        ArrayList<Farmacia> farmacias = MainActivity.farmacias;
        LatLng SANLUIS = new LatLng(-33.280576,-66.332482);
        LatLng ULP = new LatLng(-33.150720, -66.306864);
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
//           googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//           googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//         googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SANLUIS, 10));
            CameraPosition cameraPosition =
                    new CameraPosition.Builder()
                            .target(SANLUIS)
                            .zoom(19)
                            .bearing(45)
                            .tilt(90)
                            .build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            for (Farmacia farmacia:farmacias) {
                LatLng pos= new LatLng(farmacia.getLat() , farmacia.getLon());
                googleMap.addMarker(new MarkerOptions().position(pos).title(farmacia.getTitle()));
                }
         }
    }


}