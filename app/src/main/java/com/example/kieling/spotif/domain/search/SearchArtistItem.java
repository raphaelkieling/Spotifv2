package com.example.kieling.spotif.domain.search;

import java.io.Serializable;

public class SearchArtistItem  implements Serializable {

//  "id": "b3ade68b7g8f8b2ea3",
//  "url": "/anavitoria/",
//  "band": "Anavitória",
    String id;
    String url;
    String band;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getBand() {
        return band;
    }
}
