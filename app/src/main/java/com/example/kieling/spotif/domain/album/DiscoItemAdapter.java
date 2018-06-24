package com.example.kieling.spotif.domain.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kieling.spotif.AlbunsActivity;
import com.example.kieling.spotif.MusicActivity;
import com.example.kieling.spotif.R;

import java.util.ArrayList;

public class DiscoItemAdapter extends ArrayAdapter<DiscoItem> {
    public DiscoItemAdapter(@NonNull Context context, @NonNull ArrayList<DiscoItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final DiscoItem disco = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_view_adapter_item, null);

        TextView palavraItem = view.findViewById(R.id.palavraItem);
        palavraItem.setText(disco.getDesc());
        palavraItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disco.getUrl() != null){
                    Intent intent = new Intent(v.getContext(), MusicActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("music",disco);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }else{
                    Toast.makeText(getContext(),"Não existe letra para esta música",Toast.LENGTH_SHORT);
                }

            }
        });
        return view;
    }
}
