package com.rafalopez.tpo4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rafalopez.tpo4.databinding.ActivityMainBinding;
import com.rafalopez.tpo4.entity.Farmacia;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Farmacia>  farmacias=new ArrayList<>();
    // bindea las vistas
    ActivityMainBinding binding;
    // instancia el viewmodel
    MainActivityViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        farmacias.add(new Farmacia("Pirulo","Illia 256", -33.280576,-66.332482 , "L-D 8:00 24:00",
                R.drawable.ic_menu_camera ));

        farmacias.add(new Farmacia("Pirulo1","Illia 256", -33.180576,-66.232482 , "L-D 8:00 24:00",
                R.drawable.ic_menu_camera ));
        farmacias.add(new Farmacia("Pirulo2","Illia 256", -33.480576,-66.132482 , "L-D 8:00 24:00",
                R.drawable.ic_menu_camera ));

        super.onCreate(savedInstanceState);
        // instancio viewmodel
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
//        // observer del auth
        mainViewModel.getAuth().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean authBoolean) {
                Toast.makeText(MainActivity.this, "Usuario Autenticado", Toast.LENGTH_SHORT).show();
                Log.d("salida", "onChanged:" + authBoolean);

            }
        });
        // instancio binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // cambiar el atributo de setContentView
        //setContentView(R.layout.activity_main);// metodo sin usar binding
        setContentView(binding.getRoot()); // metodo usando binding
        // seteo unlistener para el button
        binding.btnIngresar.setOnClickListener(listener -> {
            String user = binding.inputUser.getText().toString();
            String pass = binding.inputPass.getText().toString();
            mainViewModel.isValidUser(user,pass);
        });

        }
}