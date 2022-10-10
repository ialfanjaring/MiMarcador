package com.iesch.alfanjarin.ivan.mimarcador;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.iesch.alfanjarin.ivan.mimarcador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //1.- Creo dos variables para las puntuaciones de cada equipo
    private int localScore = 0;
    private int visitorScore = 0;
    private String local;
    private String visitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2.- añadimos el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        nameTeams();

        // 3.- metodo para cargar los botones
        setupButtons();

    }

    private void nameTeams() {
        Bundle extras = getIntent().getExtras();
        local = extras.getString("localName");
        visitante = extras.getString("visitanteName");
        binding.localText.setText(String.valueOf(local));
        binding.visitorText.setText(String.valueOf(visitante));

    }

    private void setupButtons() {
        // 4.- Metodo para restar la puntuacion local
        binding.localMinusButton.setOnClickListener(v -> {
            if (localScore > 0) {
                localScore--;
                binding.localScoreText.setText(String.valueOf(localScore));

            }
        });
        // 5.- Me cre un metodo para restar la puntuacion visitqante
        binding.visitorMinusButton.setOnClickListener(v -> {
            if (visitorScore > 0) {
                visitorScore--;
                binding.visitorScoreText.setText(String.valueOf(visitorScore));

            }
        });
        binding.localSumarButton.setOnClickListener(v->{
            addPointsToScore(1, true);
        });
        //6.- Me cre un metodo para sumar la puntuacion local
        binding.localSumarDosButton.setOnClickListener(v->{
            addPointsToScore(2, true);
        });
        binding.localSumarTresButton.setOnClickListener(v->{
            addPointsToScore(3, true);
        });

        binding.visitorSumarButton.setOnClickListener(v->{
            addPointsToScore(1, false);
        });
        //6.- Me cre un metodo para sumar la puntuacion local
        binding.visitorSumarDosButton.setOnClickListener(v->{
            addPointsToScore(2, false);
        });
        binding.visitorSumarTresButton.setOnClickListener(v->{
            addPointsToScore(3, false);
        });

        binding.restartButton.setOnClickListener(v->{
            resetScore();
        });
        binding.resultButton.setOnClickListener(v->{
            enMatch();
        });
    }

    private void enMatch() {
        Intent intent = new Intent(this,ScoreActivity.class);
        intent.putExtra("localScore",localScore);
        intent.putExtra("visitorScore",visitorScore);
        intent.putExtra("localName", local);
        intent.putExtra("visitorName", visitante);
        startActivity(intent);

    }

    // 6 b
    private void addPointsToScore(int points, boolean isLocal) {
        if (isLocal) {
            localScore += points;
            binding.localScoreText.setText(String.valueOf(localScore));
        } else {
            visitorScore += points;
            binding.visitorScoreText.setText(String.valueOf(visitorScore));
        }

    }
    // 7.- Un boton para resetear los marcadores y pintarlos
    private void resetScore(){
        localScore=0;
        visitorScore=0;
        binding.visitorScoreText.setText(String.valueOf(visitorScore));
        binding.localScoreText.setText(String.valueOf(localScore));
    }
}