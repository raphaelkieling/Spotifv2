package com.example.kieling.spotif.domain.album;

import java.io.Serializable;

public class DiscoItem implements Serializable{
    String id;
    String desc;
    String url;

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public DiscoItem(String idp){
        this.id = idp;
    }

//    "id": "3ade68b7g864e5ea3",
//    "desc": "Cadê Você?",
//    "url": "/ivete-sangalo/cade-voce.html"
}
