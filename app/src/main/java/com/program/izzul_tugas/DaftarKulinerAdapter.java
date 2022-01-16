package com.program.izzul_tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import com.program.izzul_tugas.model.Kuliner;

public class DaftarKulinerAdapter extends ArrayAdapter<Kuliner> {

    Context context;

    public DaftarKulinerAdapter(Context context, List<Kuliner> kuliners) {
        super(context, R.layout.row_daftar_kuliner, kuliners);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Kuliner kuliner = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_kuliner, parent, false);
            viewHolder.textJenis =  convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_kuliner);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(kuliner.getRas());
        viewHolder.textAsal.setText(kuliner.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(kuliner.getDrawableRes()));
        return convertView;
    }

}
