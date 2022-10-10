package com.iesch.alfanjarin.ivan.mimarcador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.iesch.alfanjarin.ivan.mimarcador.databinding.ActivityMainBinding;
import com.iesch.alfanjarin.ivan.mimarcador.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;
    //1.- Creo dos variables para las puntuaciones de cada equipo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startButton.setOnClickListener(v -> {
            if(binding.localNameEdit.getText() != null && binding.visitorNameEdit.getText() != null){
                String local = binding.localNameEdit.getText().toString();
                String visitante = binding.visitorNameEdit.getText().toString();
                enMatch(local, visitante);
            }else{
                Toast introduceValor = Toast.makeText(getApplicationContext(), "Introduce los equipos", Toast.LENGTH_SHORT);
                introduceValor.show();
            }

        });
    }
    private void enMatch(String local, String visitante) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("localName",local);
        intent.putExtra("visitanteName",visitante);
        startActivity(intent);

    }
}