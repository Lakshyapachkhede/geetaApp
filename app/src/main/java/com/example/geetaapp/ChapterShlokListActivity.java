package com.example.geetaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChapterShlokListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShlokAdaper shlokAdaper;
    private List<Shlok> shlokList;
    private String chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_shlok_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(chapterName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.shlok_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));;

        int chapterNumber = getIntent().getIntExtra("chapter_number", 1);
        setChapterNameOnToolbar(chapterNumber);
        fetchShloks(chapterNumber);


    }

    private void fetchShloks(int chapterNumber) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://geeta-api.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService apiService = retrofit.create(ApiService.class);


        Call<List<Shlok>> call = apiService.getShloksForChapter(chapterNumber);

        call.enqueue(new Callback<List<Shlok>>() {
            @Override
            public void onResponse(Call<List<Shlok>> call, Response<List<Shlok>> response) {
                if (response.isSuccessful()) {
                    shlokList = response.body();
                    shlokAdaper = new ShlokAdaper(shlokList, new ShlokAdaper.OnItemClickListener(){
                        @Override
                        public void onItemClick(Shlok shlok, int position) {
                            Intent intent = new Intent(ChapterShlokListActivity.this, ShlokDetailPagerActivity.class);
                            intent.putExtra("position", position);
                            intent.putExtra("chapterName", chapterName);
                            intent.putParcelableArrayListExtra("shlokList", new ArrayList<>(shlokList));
                            startActivity(intent);

                        }
                    });

                    recyclerView.setAdapter(shlokAdaper);
                }
            }

            @Override
            public void onFailure(Call<List<Shlok>> call, Throwable t) {
                Toast.makeText(ChapterShlokListActivity.this, "Failed to fetch shloks", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setChapterNameOnToolbar(int chapterNumber) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://geeta-api.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);


        Call<Chapter> call = apiService.getChapter(chapterNumber);

        call.enqueue(new Callback<Chapter>() {
            @Override
            public void onResponse(Call<Chapter> call, Response<Chapter> response) {
                if (response.isSuccessful()) {
                    Chapter chapter = response.body();
                    chapterName = chapter.getName();
                    getSupportActionBar().setTitle(chapterName);




                }
            }

            @Override
            public void onFailure(Call<Chapter> call, Throwable t) {
                Toast.makeText(ChapterShlokListActivity.this, "Failed to fetch chapter name", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
