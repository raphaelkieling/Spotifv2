package com.example.kieling.spotif.domain.music;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


public class MusicArtist {
    String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    String name;

    String url;
}


//"id": "3ade68b2g3b86eda3",
//        "name": "U2",
//        "url": "https://www.vagalume.com.br/u2/"