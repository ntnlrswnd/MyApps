package com.example.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
    }
    public void openGaji(View view) {
        Intent intent = new Intent(Dashboard.this, Gaji.class);
        startActivity(intent);
    }

    public void openModul(View view){
        Intent intent = new Intent(Dashboard.this, Modul4.class);
        startActivity(intent);
    }

    public void openModul7a(View view){
        Intent intent = new Intent(Dashboard.this, Modul7a.class);
        startActivity(intent);
    }
    public void openModul7b(View view){
        Intent intent = new Intent(Dashboard.this, Modul7b.class);
        startActivity(intent);
    }

    public void openModul7Tugas(View view){
        Intent intent = new Intent(Dashboard.this, Modul7Tugas.class);
        startActivity(intent);
    }

    public void openModul8(View view){
        Intent intent = new Intent(Dashboard.this, Modul8Prak.class);
        startActivity(intent);
    }
}