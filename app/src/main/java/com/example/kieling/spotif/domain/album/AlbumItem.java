package com.example.kieling.spotif.domain.album;

import java.io.Serializable;
import java.util.List;

public class AlbumItem implements Serializable{
    String id;
    String desc;
    String url;
    String cover;
    String label;
    List<List<DiscoItem>> discs;

    public List<List<DiscoItem>> getDiscs() {
        return discs;
    }



    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getCover() {
        return cover;
    }

    public String getLabel() {
        return label;
    }

    public String getPublished() {
        return published;
    }

    String published;
//    {
//        "id":"3ade68b6g4f38fda3",
//            "desc":"No line on the horizon",
//            "url":"/u2/discografia/no-line-on-the-horizon.html",
//            "cover":"/u2/discografia/no-line-on-the-horizon-W125.jpg",
//            "label":"Island/Universal",
//            "published":"2009",
//            "discs":
//                        [
//                            [
//        {
//            "id":"3ade68b8gfd729fa3",
//                "desc":"No Line On The Horizon",
//                "url":"/u2/no-line-on-the-horizon.html"
//        },{
//        "id":"3ade68b8g47c29fa3",
//                "desc":"Magnificent",
//                "url":"/u2/magnificent.html"
//    },{
//        "id":"3ade68b8g75b29fa3",
//                "desc":"Moment Of Surrender",
//                "url":"/u2/moment-of-surrender.html"
//    },
//                                ...
//                            ]
//                            ...
//                        ]
//    }
}
