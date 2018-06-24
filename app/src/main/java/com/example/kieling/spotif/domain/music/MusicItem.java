package com.example.kieling.spotif.domain.music;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName="Music")
public class MusicItem implements Serializable{
    @DatabaseField(id = true)
    String id;
    @DatabaseField
    String name;
    @DatabaseField
    Integer lang;
    @DatabaseField
    String text;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLang() {
        return lang;
    }

    public String getText() {
        return text;
    }
}
//
//"id": "3ade68b8ge296c0b3",
//        "name": "Love Is All We Have Left",
//        "url": "https://www.vagalume.com.br/u2/love-is-all-we-have-left.html",
//        "lang": 2,
//        "text": "Nothing to stop this being the best day ever\nNothing to keep us from where we should be\nI wanted the world but you knew better\nAnd that all we have is immortality\n\nLove and love is all we have left\nA baby cries on a doorstep\nLove is all we have left\nLove and love is all we have left\nYou argue 'cause you can't accept\nLove is all we have left\n\nNow you're at the other end of the telescope\nSeven billion stars in her eyes\nSo many stars\nSo many ways of seeing\nHey, this is no time not to be alive\n\nLove and love is all we have left\nA baby cries on a doorstep\nLove is all we have left\n\nLove and love is all we have left\nThe only thing that can be kept\nLove is all we have left"