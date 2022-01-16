package com.program.izzul_tugas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.program.izzul_tugas.model.Kuliner;

public class ProfilActivity extends AppCompatActivity {

    Kuliner kuliner;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoKuliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_jenis);
        Intent intent = getIntent();
        kuliner = (Kuliner) intent.getSerializableExtra(DaftarKulinerActivity.KULINER_TERPILIH);
        inisialisasiView();
        tampilkanProfil(kuliner);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoKuliner = findViewById(R.id.gambarMakanan);
    }


    private void tampilkanProfil(Kuliner kuliner) {
        Log.d("Profil","Menampilkan "+kuliner.getJenis());
        txJudul.setText(kuliner.getJenis());
        txJenis.setText(kuliner.getRas());
        txAsal.setText(kuliner.getAsal());
        txDeskripsi.setText(kuliner.getDeskripsi());
        ivFotoKuliner.setImageDrawable(this.getDrawable(kuliner.getDrawableRes()));
    }




}