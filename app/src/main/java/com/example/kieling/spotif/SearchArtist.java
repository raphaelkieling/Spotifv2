package com.example.kieling.spotif;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kieling.spotif.api.VagalumeAPI;
import com.example.kieling.spotif.api.VagalumeService;
import com.example.kieling.spotif.domain.search.SearchArtistItem;
import com.example.kieling.spotif.domain.search.SearchArtistItemAdapter;
import com.example.kieling.spotif.domain.search.SearchArtistResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchArtist extends Fragment {
    EditText nomeArtista;
    ListView listaArtistas;
    Button procurar;
    ArrayList<SearchArtistItem> artistsArray = new ArrayList<SearchArtistItem>();
    ProgressBar progressBar;

    public SearchArtist() {
        // Required empty public constructor
    }



    protected void searchArtist(String nameArtist){
        artistsArray.clear();
        VagalumeService service = new VagalumeAPI().createService();
        Call<com.example.kieling.spotif.domain.search.SearchArtist> call = service.searchPerArtistName(VagalumeService.apikey,nomeArtista.getText().toString(),5);

        call.enqueue(new Callback<com.example.kieling.spotif.domain.search.SearchArtist>() {
            @Override
            public void onResponse(Call<com.example.kieling.spotif.domain.search.SearchArtist> call, Response<com.example.kieling.spotif.domain.search.SearchArtist> response) {
                com.example.kieling.spotif.domain.search.SearchArtist results = response.body();

                SearchArtistResponse result = results.getResponse();

                List<SearchArtistItem> artists =  result.getDocs();

                if(!artists.isEmpty()){
                    for(SearchArtistItem artist:artists){
                        artistsArray.add(artist);
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                    listaArtistas.setAdapter(new SearchArtistItemAdapter(getActivity(),artistsArray));
                }else{
                    progressBar.setVisibility(View.INVISIBLE);
                }

                procurar.setEnabled(true);
            }

            @Override
            public void onFailure(Call<com.example.kieling.spotif.domain.search.SearchArtist> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                procurar.setEnabled(true);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main,container,false);

        nomeArtista = view.findViewById(R.id.palavraItem);
        listaArtistas = view.findViewById(R.id.listaArtistas);

        procurar = view.findViewById(R.id.procurar);
        progressBar = view.findViewById(R.id.progressBar);

        procurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                procurar.setEnabled(false);
                searchArtist(nomeArtista.getText().toString());
            }
        });

        return view;
    }


}
