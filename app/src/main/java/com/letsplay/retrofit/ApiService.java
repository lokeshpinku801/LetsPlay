package com.letsplay.retrofit;

import com.letsplay.models.SongDetailResponse;
import com.letsplay.models.SongResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by girish on 16/1/17.
 */
public interface ApiService {

    @GET("url")
    Call<SongResponse> getSongList(@Path("songs") String song);

    @GET("url")
    Call<SongDetailResponse> getSongDetails(@Path("song_id") String songId);
}
