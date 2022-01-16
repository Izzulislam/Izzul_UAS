package com.program.izzul_tugas;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.program.izzul_tugas.model.Minuman;
import com.program.izzul_tugas.model.Kuliner;
import com.program.izzul_tugas.model.Makanan;

public class DataProvider {
    private static List<Kuliner> kuliners = new ArrayList<>();

    private static List<Makanan> initDataMakanan(Context ctx) {
        List<Makanan> makanans = new ArrayList<>();
        makanans.add(new Makanan(ctx.getString(R.string.bakso), "Rp.25.000,00",
                ctx.getString(R.string.des_bakso), R.drawable.makanan_bakso1));
        makanans.add(new Makanan(ctx.getString(R.string.gudeg), "Rp.20.000,00",
                ctx.getString(R.string.des_gudeg), R.drawable.makanan_gudeg2));
        makanans.add(new Makanan(ctx.getString(R.string.lumpia), "Rp.2.500,00",
                ctx.getString(R.string.des_lumpia), R.drawable.makanan_lumpia3));
        makanans.add(new Makanan(ctx.getString(R.string.goreng), "Rp.25.000,00",
                ctx.getString(R.string.des_goreng), R.drawable.makanan_nasigoreng4));
        makanans.add(new Makanan(ctx.getString(R.string.liwet), "Rp.15.000,00",
                ctx.getString(R.string.des_liwet), R.drawable.makanan_nasiliwet5));
        makanans.add(new Makanan(ctx.getString(R.string.tengkelek), "Rp.12.000,00",
                ctx.getString(R.string.des_tengkelek), R.drawable.makanan_tengkleng6));
        return makanans;
    }

    private static List<Minuman> initDataMinuman(Context ctx) {
        List<Minuman> minumans = new ArrayList<>();
        minumans.add(new Minuman(ctx.getString(R.string.wedamguwu), "Rp.10.000,00",
                ctx.getString(R.string.des_wedamguwu), R.drawable.minuman_wedanguwuh1));
        minumans.add(new Minuman(ctx.getString(R.string.bajigur), "Rp.17.000,00",
                ctx.getString(R.string.des_bajigur), R.drawable.minuman_bajigur2));
        minumans.add(new Minuman(ctx.getString(R.string.bandrek), "Rp.20.000,00",
                ctx.getString(R.string.des_bandrek), R.drawable.minuman_bandrek3));
        minumans.add(new Minuman(ctx.getString(R.string.birpletol), "Rp.12.000,00",
                ctx.getString(R.string.des_birpletol), R.drawable.minuman_birpletok4));
        minumans.add(new Minuman(ctx.getString(R.string.sarabba), "Rp,7.000,00",
                ctx.getString(R.string.des_sarabba), R.drawable.minuman_sarabba5));
        minumans.add(new Minuman(ctx.getString(R.string.tehtalus), "Rp.25.000,00",
                ctx.getString(R.string.des_tehtalus),R.drawable.minuman_tehtalua6));

        return minumans;
    }

    private static void initAllKuliners(Context ctx) {
        kuliners.addAll(initDataMakanan(ctx));
        kuliners.addAll(initDataMinuman(ctx));
    }

    public static List<Kuliner> getAllKuliner(Context ctx) {
        if (kuliners.size() == 0) {
            initAllKuliners(ctx);
        }
        return  kuliners;
    }

    public static List<Kuliner> getKulinersByTipe(Context ctx, String jenis) {
        List<Kuliner> kulinersByType = new ArrayList<>();
        if (kuliners.size() == 0) {
            initAllKuliners(ctx);
        }
        for (Kuliner h : kuliners) {
            if (h.getJenis().equals(jenis)) {
                kulinersByType.add(h);
            }
        }
        return kulinersByType;
    }

}
