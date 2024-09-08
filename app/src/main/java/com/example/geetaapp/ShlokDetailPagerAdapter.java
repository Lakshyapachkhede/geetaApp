package com.example.geetaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ShlokDetailPagerAdapter extends RecyclerView.Adapter<ShlokDetailPagerAdapter.ShlokViewHolder>{
    private List<Shlok> shlokList;



    public ShlokDetailPagerAdapter(List<Shlok> shlokList) {
        this.shlokList = shlokList;

    }

    @NonNull
    @Override
    public ShlokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shlok_detail_pager_item, parent, false);
        return new ShlokViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ShlokViewHolder holder, int position) {
        Shlok shlok = shlokList.get(position);
        holder.shlokText.setText(shlok.getText());
        holder.shlokHeading.setText("श्लोक " + shlok.getShlokNo());
        holder.shlokMeaning.setText(shlok.getMeaning());
    }


    @Override
    public int getItemCount() {
        return shlokList.size();
    }





    public static class ShlokViewHolder extends RecyclerView.ViewHolder{
        TextView shlokHeading, shlokText, shlokMeaning;

        public ShlokViewHolder(@NonNull View itemView) {
            super(itemView);
            shlokHeading = itemView.findViewById(R.id.shlok_heading);
            shlokText = itemView.findViewById(R.id.shlok_text);
            shlokMeaning = itemView.findViewById(R.id.shlok_meaning);
        }

    }
}
