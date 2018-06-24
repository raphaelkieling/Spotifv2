package com.example.kieling.spotif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kieling.spotif.api.VagalumeAPI;
import com.example.kieling.spotif.api.VagalumeService;
import com.example.kieling.spotif.domain.album.AlbumItem;
import com.example.kieling.spotif.domain.album.AlbumItemAdapter;
import com.example.kieling.spotif.domain.album.AlbumResponse;
import com.example.kieling.spotif.domain.album.DiscoItem;
import com.example.kieling.spotif.domain.album.DiscographyResponse;
import com.example.kieling.spotif.domain.search.SearchArtistItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbunsActivity extends AppCompatActivity {
    TextView nomeArtista;
    SearchArtistItem artista;
    GridView gridView;
    ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albuns);

        Bundle extras = getIntent().getExtras();
        artista = (SearchArtistItem) extras.getSerializable("artist");

        nomeArtista = findViewById(R.id.palavraItem);
        nomeArtista.setText(artista.getBand());

        gridView = findViewById(R.id.gridAlbums);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.VISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchAlbunsArtist();
    }

    protected void searchAlbunsArtist(){
        VagalumeService service = new VagalumeAPI().createService();
        Call<AlbumResponse> call = service.discografiaArtista(artista.getUrl());

        call.enqueue(new Callback<AlbumResponse>() {
            @Override
            public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                AlbumResponse res = response.body();

                DiscographyResponse discography =  res.getDiscography();
                List<AlbumItem> items =  discography.getItem();


                AlbumItemAdapter gridAdapter = new AlbumItemAdapter(AlbunsActivity.this,items);
                gridView.setAdapter(gridAdapter);

                progressBar2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<AlbumResponse> call, Throwable t) {
                progressBar2.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
