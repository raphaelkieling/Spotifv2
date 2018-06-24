package com.example.kieling.spotif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kieling.spotif.api.VagalumeAPI;
import com.example.kieling.spotif.api.VagalumeService;
import com.example.kieling.spotif.domain.album.DiscoItem;
import com.example.kieling.spotif.domain.music.MusicItem;
import com.example.kieling.spotif.domain.music.MusicResponse;
import com.example.kieling.spotif.ormlite.DatabaseHelper;
import com.example.kieling.spotif.ormlite.MusicItemDAO;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicActivity extends AppCompatActivity {
    DiscoItem disco;
    Button btnSave;
    private DatabaseHelper db;
    private MusicItemDAO musicDAO;
    private MusicItem musicItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Bundle extras = getIntent().getExtras();
        disco = (DiscoItem) extras.getSerializable("music");
        db = new DatabaseHelper(MusicActivity.this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    musicDAO = new MusicItemDAO(db.getConnectionSource());
                    MusicItem musicBdUnique  = musicDAO.queryForId(musicItem.getId());
                    if(musicBdUnique != null){
                        musicDAO.delete(musicItem);
                        btnSave.setText(R.string.save);
                    }else{
                        musicDAO.create(musicItem);
                        btnSave.setText(R.string.saved);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        getMusic();
    }

    protected void getMusic(){
        VagalumeService service = new VagalumeAPI().createService();
        Call<MusicResponse> call = service.music(VagalumeService.apikey, disco.getId());

        call.enqueue(new Callback<MusicResponse>() {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response) {
                MusicResponse res = response.body();
                musicItem = res.getMus().get(0);

                try {
                    musicDAO = new MusicItemDAO(db.getConnectionSource());
                    MusicItem musicBdUnique  = musicDAO.queryForId(musicItem.getId());
                    if(musicBdUnique != null){
                        btnSave.setText("Salvo");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                TextView nameArtist = findViewById(R.id.name_artist);
                TextView nameMusic = findViewById(R.id.name_music);
                TextView musicText = findViewById(R.id.music_text);

                nameMusic.setText(musicItem.getName());
                nameArtist.setText(res.getArt().getName());
                musicText.setText(musicItem.getText());
            }

            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t) {

            }
        });
    }

}
