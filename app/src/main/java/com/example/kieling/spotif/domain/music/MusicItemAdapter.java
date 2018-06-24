package com.example.kieling.spotif.domain.music;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kieling.spotif.MusicActivity;
import com.example.kieling.spotif.R;
import com.example.kieling.spotif.domain.album.DiscoItem;

import java.util.ArrayList;

public class MusicItemAdapter extends ArrayAdapter<MusicItem> {
    public MusicItemAdapter(@NonNull Context context, @NonNull ArrayList<MusicItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final MusicItem music = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_view_adapter_item, null);


        TextView palavraItem = view.findViewById(R.id.palavraItem);
        palavraItem.setText(music.getName());
        palavraItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music != null){
                    Intent intent = new Intent(v.getContext(), MusicActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("music",new DiscoItem(music.getId()));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }else{
                    Snackbar.make(v,"Não existe letra para esta música",Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
        return view;
    }
}
