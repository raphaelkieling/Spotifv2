package com.example.kieling.spotif.api;

import com.example.kieling.spotif.domain.album.AlbumResponse;
import com.example.kieling.spotif.domain.search.SearchArtist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VagalumeService {
    String apikey = "73c35725dc89bfe29dcce2596f5a4841";

    @GET("search.art")
    Call<SearchArtist> searchPerArtistName(@Query("apikey") String key,
                                           @Query("q") String query,
                                           @Query("limit") Number limit);
    @GET("{nomeArtista}/discografia/index.js")
    Call<AlbumResponse> discografiaArtista(@Path("nomeArtista") String nomeArtista);
}
