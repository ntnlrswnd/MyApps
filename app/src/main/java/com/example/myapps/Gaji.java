package com.example.myapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;

public class Gaji extends AppCompatActivity {

    private EditText namaEditText;
    private RadioGroup statusRadioGroup;
    private Spinner golonganSpinner, jabatanSpinner;
    private Button hitungButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji);

        // Menghubungkan elemen dengan XML
        namaEditText = findViewById(R.id.nama);
        statusRadioGroup = findViewById(R.id.grupstatus);
        golonganSpinner = findViewById(R.id.spinner_golongan);
        jabatanSpinner = findViewById(R.id.spinner_jabatan);
        hitungButton = findViewById(R.id.hitung);

        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data dari EditText, RadioGroup, dan Spinner
                String nama = namaEditText.getText().toString();
                String status = ((RadioButton) findViewById(statusRadioGroup.getCheckedRadioButtonId())).getText().toString();
                String golongan = golonganSpinner.getSelectedItem().toString();
                String jabatan = jabatanSpinner.getSelectedItem().toString();

                // Logika perhitungan gaji
                int totalGaji = hitungGaji(golongan, jabatan, status); // Memasukkan status ke dalam metode hitungGaji

                // Tampilkan pop-up menggunakan AlertDialog
                showPopup(nama, status, golongan, jabatan, totalGaji);
            }
        });
    }

    // Metode untuk menghitung gaji
    private int hitungGaji(String golongan, String jabatan, String status) {
        int gaji = 0;

        // Menambah gaji berdasarkan status
        if (status.equalsIgnoreCase("Menikah")) {
            gaji += 500000;
        } else if (status.equalsIgnoreCase("Belum Menikah")) {
            gaji += 200000;
        }

        // Menambah gaji berdasarkan golongan
        switch (golongan) {
            case "Golongan I":
                gaji += 3000000;
                break;
            case "Golongan II":
                gaji += 2000000;
                break;
            case "Golongan III":
                gaji += 1000000;
                break;
            default:
                break;
        }

        // Menambah gaji berdasarkan jabatan
        if (jabatan.equalsIgnoreCase("Staff")) {
            gaji += 1000000;
        } else if (jabatan.equalsIgnoreCase("NOC")) {
            gaji += 1500000;
        } else if (jabatan.equalsIgnoreCase("MANAGER")) {
            gaji += 2000000;
        }

        return gaji;
    }

    // Metode untuk menampilkan pop-up
    private void showPopup(String nama, String status, String golongan, String jabatan, int totalGaji) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_gaji, null);
        builder.setView(dialogView);

        // Menghubungkan elemen dalam layout pop-up dengan data yang diambil
        TextView namaTextView = dialogView.findViewById(R.id.dialog_nama);
        TextView statusTextView = dialogView.findViewById(R.id.dialog_status);
        TextView golonganTextView = dialogView.findViewById(R.id.dialog_golongan);
        TextView jabatanTextView = dialogView.findViewById(R.id.dialog_jabatan);
        TextView gajiTextView = dialogView.findViewById(R.id.dialog_total_gaji);

        namaTextView.setText(nama);
        statusTextView.setText(status);
        golonganTextView.setText(golongan);
        jabatanTextView.setText(jabatan);
        gajiTextView.setText("Rp." + totalGaji);

        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
