package com.example.kieling.spotif.domain.music;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.List;

public class MusicResponse {
    private int id;

    public List<MusicItem> getMus() {
        return mus;
    }

    List<MusicItem> mus;

    public MusicArtist getArt() {
        return art;
    }

    MusicArtist art;
}
