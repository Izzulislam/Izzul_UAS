package com.program.izzul_tugas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.program.izzul_tugas.model.Kuliner;
import com.program.izzul_tugas.model.Makanan;
import com.program.izzul_tugas.model.Minuman;

public class DaftarKulinerActivity extends AppCompatActivity {
    public final static String KULINER_TERPILIH ="kuliner_obj_key";
    List<Kuliner> kuliners;
    ListView listView;
    String jenisKuliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kuliner);
        Intent intent = getIntent();
        jenisKuliner = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        kuliners = DataProvider.getKulinersByTipe(this,jenisKuliner);

        TextView txJudul = findViewById(R.id.text_title_daftar);
        String judul="";
        if (kuliners.get(0) instanceof Makanan) {
            judul = getString(R.string.judul_Makanan);
        } else if (kuliners.get(0) instanceof Minuman) {
            judul = getString(R.string.judul_Minuman);
        }
        txJudul.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_kuliner);
        DaftarKulinerAdapter adapter = new DaftarKulinerAdapter(this,kuliners);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Kuliner terpilih = kuliners.get(position);
            bukaProfileKuliner(terpilih);
        }
    };

    private void bukaProfileKuliner(Kuliner kulinerTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra(KULINER_TERPILIH, kulinerTerpilih);
        startActivity(intent);
    }


}