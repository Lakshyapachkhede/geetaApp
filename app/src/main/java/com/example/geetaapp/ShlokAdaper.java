package com.example.geetaapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShlokAdaper  extends RecyclerView.Adapter<ShlokAdaper.ViewHolder> {
    private List<Shlok> shlokList;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Shlok shlok, int position);
    }


    public ShlokAdaper(List<Shlok> shlokList, OnItemClickListener listener) {
        this.listener = listener;
        this.shlokList = shlokList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter_shlok_list_item, parent, false);
        return new ViewHolder(view);

    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shlok shlok = shlokList.get(position);
        holder.shlokName.setText( "श्लोक " + shlok.getShlokNo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(shlok, position);
                }
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return shlokList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView shlokName;
        public ViewHolder(View itemView){
            super(itemView);
            shlokName = itemView.findViewById(R.id.shlok_name);

        }
    }
}
