package com.example.myapplication.ui.gallery;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.MainActivity;

public class GalleryViewModel extends AndroidViewModel {


    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }
    public void setNota(String nota){
        if(nota.isEmpty()){
                 Toast.makeText(getApplication(),"No ha ingresado Nota \n Ingrese una nota",Toast.LENGTH_SHORT).show();
                return;
            }
        MainActivity.notas.add(nota);
    }

}