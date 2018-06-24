package com.example.kieling.spotif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kieling.spotif.domain.album.DiscoItem;
import com.example.kieling.spotif.domain.album.DiscoItemAdapter;

import java.util.ArrayList;

public class MusicsActivity extends AppCompatActivity {

    ArrayList<DiscoItem> discos;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musics);

        list = findViewById(R.id.listMusics);
        Bundle extras = getIntent().getExtras();
        discos = (ArrayList<DiscoItem>) extras.getSerializable("discos");

        list.setAdapter(new DiscoItemAdapter(MusicsActivity.this,discos));
    }
}
