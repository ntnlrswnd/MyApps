package com.example.myapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    public void openModul5(View view){
        Intent intent = new Intent(Dashboard.this, Modul5.class);
        startActivity(intent);
    }
    public void openModul7(View view){
        Intent intent = new Intent(Dashboard.this, Modul7.class);
        startActivity(intent);
    }
    public void openModul6(View view){
        Intent intent = new Intent(Dashboard.this, Modul6.class);
        startActivity(intent);
    }

    public void openModul8(View view){
        Intent intent = new Intent(Dashboard.this, Modul8Prak.class);
        startActivity(intent);
    }

    public void openModul9(View view){
        Intent intent = new Intent(Dashboard.this, Modul9.class);
        startActivity(intent);
    }

    public void openModul9RecycleView(View view){
        Intent intent = new Intent(Dashboard.this, Modul9RecycleView.class);
        startActivity(intent);
    }

}