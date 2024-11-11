package com.example.myapps;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Modul4 extends AppCompatActivity {

    private EditText nama, nim, nilai;
    private Button btncek;
    private TextView NAMA, NIM, NILAI, STATUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modul4);

        // Inisialisasi komponen
        nama = findViewById(R.id.nama_mhs);
        nim = findViewById(R.id.nim);
        nilai = findViewById(R.id.nilai);
        btncek = findViewById(R.id.btn_cek);

        // Inisialisasi TextView tambahan
        NAMA = findViewById(R.id.NAMA);
        NIM = findViewById(R.id.NIM);
        NILAI = findViewById(R.id.NILAI);
        STATUS = findViewById(R.id.STATUS);

        // Logika untuk tombol cek kelulusan
        btncek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaInput = nama.getText().toString();
                String nimInput = nim.getText().toString();
                String nilaiInput = nilai.getText().toString();

                if (namaInput.isEmpty() || nimInput.isEmpty() || nilaiInput.isEmpty()) {
                    Toast.makeText(Modul4.this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int nilaiInt;
                try {
                    nilaiInt = Integer.parseInt(nilaiInput);
                } catch (NumberFormatException e) {
                    Toast.makeText(Modul4.this, "Nilai harus berupa angka!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nilaiInt < 0 || nilaiInt > 100) {
                    Toast.makeText(Modul4.this, "Nilai harus antara 1-100!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mengecek grade dan kelulusan berdasarkan nilai
                String grade;
                String hasilKelulusan;

                if (nilaiInt >= 81 && nilaiInt <= 100) {
                    grade = "A";
                    hasilKelulusan = "LULUS";
                } else if (nilaiInt >= 61 && nilaiInt <= 80) {
                    grade = "B";
                    hasilKelulusan = "LULUS";
                } else if (nilaiInt >= 41 && nilaiInt <= 60) {
                    grade = "C";
                    hasilKelulusan = "MENGULANG";
                } else {
                    grade = "D";
                    hasilKelulusan = "TIDAK LULUS";
                }

                // Menampilkan hasil pada TextView yang relevan
                NAMA.setText(namaInput);
                NIM.setText(nimInput);
                NILAI.setText(nilaiInt + " (" + grade + ")");
                STATUS.setText(hasilKelulusan);

                nama.clearFocus();
                nim.clearFocus();
                nilai.clearFocus();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

            }
        });
    }

    public void reset(View view){
        nama.setText("");
        nim.setText("");
        nilai.setText("");

        // Hilangkan fokus dari semua EditText
        nama.clearFocus();
        nim.clearFocus();
        nilai.clearFocus();

        // Hapus hasil di TextView
        NAMA.setText("");
        NIM.setText("");
        NILAI.setText("");
        STATUS.setText("");
    }
}
