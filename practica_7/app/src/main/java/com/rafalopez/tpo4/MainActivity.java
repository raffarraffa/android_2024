package com.rafalopez.tpo4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.rafalopez.tpo4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // bindea las vistas
    ActivityMainBinding binding;
    // instancia el viewmodel
    MainActivityViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // instancio viewmodel
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        // instancio binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // cambiar el atributo de setContentView
        //setContentView(R.layout.activity_main);// metodo sin usar binding
        setContentView(binding.getRoot()); // metodo usando binding
        // seteo unlistener para el button
        binding.btnIngresar.setOnClickListener(listener -> {

        });
        }
}