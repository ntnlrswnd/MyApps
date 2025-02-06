package com.example.myapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Modul7 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modul7);
        Button prak1 = findViewById(R.id.prak1);
        Button prak2 = findViewById(R.id.prak2);
        Button tugas = findViewById(R.id.tugas);

        prak1.setOnClickListener(this);
        prak2.setOnClickListener(this);
        tugas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.prak1){
            Intent intent = new Intent(Modul7.this, Modul7a.class);
            startActivity(intent);
        } else if (id == R.id.prak2){
            Intent intent = new Intent(Modul7.this, Modul7b.class);
            startActivity(intent);
        } else if (id == R.id.tugas){
            Intent intent = new Intent(Modul7.this, Modul7Tugas.class);
        }
    }
}