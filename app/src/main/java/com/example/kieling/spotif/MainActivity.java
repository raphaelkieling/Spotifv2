package com.example.kieling.spotif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kieling.spotif.api.VagalumeAPI;
import com.example.kieling.spotif.api.VagalumeService;
import com.example.kieling.spotif.domain.search.SearchArtist;
import com.example.kieling.spotif.domain.search.SearchArtistItem;
import com.example.kieling.spotif.domain.search.SearchArtistItemAdapter;
import com.example.kieling.spotif.domain.search.SearchArtistResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    EditText nomeArtista;
    ListView listaArtistas;
    Button procurar;
    ArrayList<SearchArtistItem> artistsArray = new ArrayList<SearchArtistItem>();
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeArtista = findViewById(R.id.palavraItem);
        listaArtistas = findViewById(R.id.listaArtistas);

        procurar = findViewById(R.id.procurar);
        progressBar = findViewById(R.id.progressBar);

        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                procurar.setEnabled(false);
                searchArtist(nomeArtista.getText().toString());
            }
        });
    }

    protected void searchArtist(String nameArtist){
        artistsArray.clear();
        VagalumeService service = new VagalumeAPI().createService();
        Call<SearchArtist> call = service.searchPerArtistName(VagalumeService.apikey,nomeArtista.getText().toString(),5);

        call.enqueue(new Callback<SearchArtist>() {
            @Override
            public void onResponse(Call<SearchArtist> call, Response<SearchArtist> response) {
                SearchArtist results = response.body();

                SearchArtistResponse result = results.getResponse();

                List<SearchArtistItem> artists =  result.getDocs();

                if(!artists.isEmpty()){
                    for(SearchArtistItem artist:artists){
                        artistsArray.add(artist);
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                    listaArtistas.setAdapter(new SearchArtistItemAdapter(MainActivity.this,artistsArray));
                }else{
                    progressBar.setVisibility(View.INVISIBLE);
                }

                procurar.setEnabled(true);
            }

            @Override
            public void onFailure(Call<SearchArtist> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                procurar.setEnabled(true);
            }
        });
    }


}
