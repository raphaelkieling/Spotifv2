package com.example.kieling.spotif.domain.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kieling.spotif.AlbunsActivity;
import com.example.kieling.spotif.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchArtistItemAdapter extends ArrayAdapter<SearchArtistItem> {
    private Activity activity;
    public SearchArtistItemAdapter(@NonNull Activity activity, ArrayList<SearchArtistItem> resource) {
        super(activity,0, resource);
        activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final SearchArtistItem artist = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_view_adapter_item, null);

        TextView nomeArtista = view.findViewById(R.id.nomeArtista);
        nomeArtista.setText(artist.getBand());

        nomeArtista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AlbunsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("artist",artist);
                intent.putExtras(bundle);

                view.getContext().startActivity(intent);
            }
        });
        return view;
    }


}
