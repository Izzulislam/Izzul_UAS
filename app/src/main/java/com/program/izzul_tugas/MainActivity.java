package com.program.izzul_tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnMakanan,btnMinuman;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnMakanan = findViewById(R.id.btn_buka_ras_makanan);
        btnMinuman = findViewById(R.id.btn_buka_ras_minuman);
        btnMakanan.setOnClickListener(view -> bukaGaleri("Makanan"));
        btnMinuman.setOnClickListener(view -> bukaGaleri("Minuman"));
    }

    private void bukaGaleri(String jenisMakanan) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, DaftarKulinerActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisMakanan);
        startActivity(intent);
    }

}