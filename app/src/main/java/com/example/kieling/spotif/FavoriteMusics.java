package com.example.kieling.spotif;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kieling.spotif.domain.music.MusicItem;
import com.example.kieling.spotif.domain.music.MusicItemAdapter;
import com.example.kieling.spotif.ormlite.DatabaseHelper;
import com.example.kieling.spotif.ormlite.MusicItemDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FavoriteMusics extends Fragment {

    private DatabaseHelper db;
    private MusicItemDAO musicDAO;
    private View v;

    public FavoriteMusics() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_favorite_musics, container, false);
        setListInActivity();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        setListInActivity();
    }

    void setListInActivity(){
        ListView listFavorite = v.findViewById(R.id.favoriteMusics);
        db = new DatabaseHelper(getActivity());
        try{
            musicDAO = new MusicItemDAO(db.getConnectionSource());
            List<MusicItem> favoriteMusic = musicDAO.queryForAll();
            ArrayList<MusicItem> arrayFavoriteMusic = new ArrayList<MusicItem>();

            for(MusicItem music: favoriteMusic){
                arrayFavoriteMusic.add(music);
            }

            listFavorite.setAdapter(new MusicItemAdapter(getActivity(), arrayFavoriteMusic));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
