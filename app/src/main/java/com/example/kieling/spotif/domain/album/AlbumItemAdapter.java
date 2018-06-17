package com.example.kieling.spotif.domain.album;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.kieling.spotif.R;
import com.example.kieling.spotif.api.VagalumeAPI;

import java.util.List;

public class AlbumItemAdapter extends BaseAdapter {
    private List<AlbumItem> items;
    private Context context;
    private LayoutInflater inflater;

    public AlbumItemAdapter(Context context, List<AlbumItem> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View gridView = view;
        AlbumItem albumItem = items.get(i);

        if(view == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.grid_adapter,null);
        }

        ImageView capaAlbum = gridView.findViewById(R.id.capaAlbum);
        TextView nomeAlbum = gridView.findViewById(R.id.nomeAlbum);
        nomeAlbum.setText(albumItem.getDesc());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);


        Glide.with(context)
                .load(VagalumeAPI.url+albumItem.getCover())
                .apply(requestOptions)
                .into(capaAlbum);


        return gridView;
    }
}
