package com.example.geetaapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ChapterAdapter chapterAdapter;
    private List<Chapter> chapterList;
    private LinearLayout noInternetLayout;
    private Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("श्रीमद्भगवद्गीता");

        listView = findViewById(R.id.chapter_list);
        noInternetLayout = findViewById(R.id.no_internet_layout);
        retryButton = findViewById(R.id.retry_button);

        checkInternetConnection();

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternetConnection();
            }
        });

        chapterList = new ArrayList<>();


        chapterAdapter = new ChapterAdapter(this, chapterList);
        listView.setAdapter(chapterAdapter);

        fetchChapters();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter selectedChapter = chapterList.get(position);

                Intent intent = new Intent(MainActivity.this, ChapterShlokListActivity.class);
                intent.putExtra("chapter_number", selectedChapter.getNumber());

                startActivity(intent);


            }
        });

    }
    private void fetchChapters() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://geeta-api.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<Chapter>> call = apiService.getChapters();
        call.enqueue(new Callback<List<Chapter>>() {
            @Override
            public void onResponse(Call<List<Chapter>> call, Response<List<Chapter>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    chapterList.clear();

                    chapterList.addAll(response.body());

                    chapterAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Chapter>> call, Throwable t) {
                Log.e("MainActivity", "Error Fetching chapter's data", t);
            }
        });
    }
    private void checkInternetConnection() {
        if (isConnected()) {
            noInternetLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            fetchChapters();
        } else {
            noInternetLayout.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }
    }
    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }







}