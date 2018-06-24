package com.example.kieling.spotif.ormlite;

import com.example.kieling.spotif.domain.music.MusicItem;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class MusicItemDAO extends BaseDaoImpl<MusicItem,String> {
    public MusicItemDAO(ConnectionSource cs) throws SQLException {
        super(MusicItem.class);
        setConnectionSource(cs);
        initialize();
    }


}
