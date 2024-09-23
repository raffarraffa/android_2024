package com.rafalopez.tpo4.ui.gallery;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.rafalopez.tpo4.MainActivity;
import com.rafalopez.tpo4.entity.Farmacia;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mMapaActual;
    private FusedLocationProviderClient fused;
    private Context context;
    LatLng posActual;


    public GalleryViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
        context = getApplication();

    }

    public LiveData<MapaActual> getMapaActual() {
        if (mMapaActual == null) {
            mMapaActual = new MutableLiveData<>();
        }
        Log.d("mapa", "Ubicación obtenida:57 " + posActual);
        //obtenerUbicacion();
        return mMapaActual;
    }

    public void obtenerMapa() {
        MapaActual mapaActual = new MapaActual();
        mMapaActual.setValue(mapaActual);
    }


    public class MapaActual implements OnMapReadyCallback {
        ArrayList<Farmacia> farmacias = MainActivity.farmacias;
        //LatLng ULP = new LatLng(-33.150720, -66.306864);
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
//           googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//           googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//         googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posActual, 10));
//            CameraPosition cameraPosition =
//                    new CameraPosition.Builder()
//                            .target(posActual)
//                            .zoom(19)
//                            .bearing(45)
//                            .tilt(90)
//                            .build();
//
//            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posActual, 10));
            if (posActual != null) {
               // googleMap.addMarker(new MarkerOptions().position(posActual).title("Posicion Actual"));
                googleMap.addMarker(new MarkerOptions()
                        .position(posActual)
                        .title("Posición Actual")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
            for (Farmacia farmacia : farmacias) {
                LatLng pos = new LatLng(farmacia.getLat(), farmacia.getLon());
                googleMap.addMarker(new MarkerOptions().position(pos).title(farmacia.getTitle()));
            }
        }
    }

   public void requestLocationUpdates() {
        if(posActual==null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            fused.requestLocationUpdates(LocationRequest.create().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY), new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult != null && !locationResult.getLocations().isEmpty()) {
                        Location location = locationResult.getLastLocation();
                        if (location != null) {
                            double lat = location.getLatitude();
                            double lon = location.getLongitude();
                            posActual = new LatLng(lat, lon);
                            Log.d("mapa", "Ubicación obtenida: " + posActual);
                            obtenerMapa();
                        }
                    }
                }
            }, Looper.getMainLooper());
        }
    }
    public void obtenerUbicacion() {
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(context,"NO TIENE PERMISOS", Toast.LENGTH_SHORT).show();
            return;
        }

        Task<Location> tarea = fused.getLastLocation();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tarea.addOnSuccessListener(getApplication().getMainExecutor(),
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {
                                double lat = location.getLatitude();
                                double lon = location.getLongitude();
                                posActual = new LatLng(lat,lon);
                                Log.d("mapa","linea 118");
                            }
                            Log.d("mapa","linea 121");
                        }
                    });
        } else {
            tarea.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        double lat = location.getLatitude();
                        double lon = location.getLongitude();
                        posActual = new LatLng(lat,lon);
                        Log.d("mapa","linea 132");
                    }
                    Toast.makeText(context, "loction null", Toast.LENGTH_LONG).show();
                    Log.d("mapa","linea 134");
                }
            });
        }
    }
}