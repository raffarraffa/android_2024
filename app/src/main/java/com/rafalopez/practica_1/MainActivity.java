package com.rafalopez.practica_1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btnClick1(View v) {
         // usando this,  this hace referencia a la isntnacia de esta clase, es un Context
        Toast.makeText(this, "Button Click usando this", Toast.LENGTH_SHORT).show();
        //usnado getApplicaction() hace referencia a la instancia global de la aplicacion
        Toast.makeText(getApplication(), "Button Click usnado getApplication",
                Toast.LENGTH_SHORT).show();

    }
    public void btnClick2(View v) {
        //  modificar posicion  Toast
        Toast toast = Toast.makeText(this, "Modificando Posicion btn2",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
        toast.show();
    }

}