package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.VideoPlayer;
import com.android.alekhya.revisionv3.network.PojoClasses.Mvideos;

import java.util.ArrayList;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class VedioAdapter extends RecyclerView.Adapter<VedioAdapter.ViewHolder> {
    private ArrayList<Mvideos> android;
    public VedioAdapter(ArrayList<Mvideos> android) {
        this.android = android;
    }
    @Override
    public VedioAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(VedioAdapter.ViewHolder viewHolder, int i) {
        BaseApplication.url=android.get(i).getVedios_name();
        BaseApplication.filename = android.get(i).getFilename();
        viewHolder.tv_name.setText(android.get(i).getFilename());
    }
    @Override
    public int getItemCount() {
        return android.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        public ViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), VideoPlayer.class));
                }
            });
        }
    }
}
