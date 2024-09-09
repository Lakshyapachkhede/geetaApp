package com.example.geetaapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class ShlokDetailPagerActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private List<Shlok> shlokList;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlok_detail_pager);

        shlokList = (List<Shlok>) getIntent().getSerializableExtra("shlokList");
        int position = getIntent().getIntExtra("position", 0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("chapterName"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        ShlokDetailPagerAdapter adapter = new ShlokDetailPagerAdapter(shlokList);
        viewPager.setAdapter(adapter);

        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        viewPager.setCurrentItem(position, false);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.toolbar_info){
            showInfoDialog();
            return true;
        } else if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("This app is created by Lakshya Pachkhede. For more projects, visit my GitHub (https://github.com/Lakshyapachkhede).\n")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }




}
