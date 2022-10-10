package com.iesch.alfanjarin.ivan.mimarcador;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.iesch.alfanjarin.ivan.mimarcador.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1.- Recojo las puntuiaciones que vienen del marcador

        Integer localScore = getIntent().getExtras().getInt("localScore");
        Integer visitorScore = getIntent().getExtras().getInt("visitorScore");
        //2.- Dibujo las puntuaciones obtenidas y escribo el texto
        binding.scoreText.setText(String.valueOf(localScore) + " - " + visitorScore.toString());

        Bundle extras = getIntent().getExtras();
        String local = extras.getString("localName");
        String visitor = extras.getString("visitorName");

        binding.tituloEquiposText.setText(local + " vs " + visitor);
        if(localScore>visitorScore){
            binding.whoWonText.setText("Gano el equipo " + local);
        }else if(localScore<visitorScore){
            binding.whoWonText.setText("Gano el equipo " + visitor);
        }else{
            binding.whoWonText.setText(local + " y " + visitor + " empataron");
        }
    }
}