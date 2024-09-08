package com.example.geetaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("adhyay/")
    Call<List<Chapter>> getChapters();

    @GET("adhyay/{chapter}")
    Call <Chapter> getChapter(@Path("chapter") int chapterNumber);

    @GET("shlok/{chapter}")
    Call<List<Shlok>> getShloksForChapter(@Path("chapter") int chapterNumber);

    @GET("shlok/{chapter}/{shlok}")
    Call<Shlok> getShlokDetail(
            @Path("chapter") int chapterNumber,
            @Path("shlok") int shlokNumber
    );
}
