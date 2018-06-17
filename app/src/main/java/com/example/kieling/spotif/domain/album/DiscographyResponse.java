package com.example.kieling.spotif.domain.album;

import java.util.List;

public class DiscographyResponse {
    Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public List<AlbumItem> getItem() {
        return item;
    }

    List<AlbumItem> item;
}
