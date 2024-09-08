package com.example.geetaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Layer;

import java.util.List;

public class ChapterAdapter extends ArrayAdapter<Chapter> {
    private Context context;
    private List<Chapter> chapterList;

    public ChapterAdapter(@NonNull Context context, @NonNull List<Chapter> objects) {
        super(context, 0, objects);
        this.context = context;
        this.chapterList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chapter_list_item, parent, false);
        }

        Chapter currentChapter = chapterList.get(position);

        TextView hindiNumberTextView = convertView.findViewById(R.id.hindi_number);
        TextView nameTextView = convertView.findViewById(R.id.chapter_name);

        hindiNumberTextView.setText(currentChapter.getHindiNumber());
        nameTextView.setText(currentChapter.getName());

        return convertView;
    }



}
