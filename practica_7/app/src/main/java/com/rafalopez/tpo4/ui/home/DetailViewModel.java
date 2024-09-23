package com.rafalopez.tpo4.ui.home;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.tpo4.entity.Farmacia;

public class DetailViewModel extends AndroidViewModel {

    MutableLiveData<Farmacia> mMFarmacia;

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Farmacia> getFarmacia() {
        if(mMFarmacia == null){
            mMFarmacia = new MutableLiveData<Farmacia>();
        }
        return  mMFarmacia;
    }
    public void getDetailFarmacia(Bundle bundle){
        Farmacia farmacia = (Farmacia) bundle.getSerializable("farmacia");
        mMFarmacia.setValue(farmacia);
    }
}