package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.DisplayPDF;
import com.android.alekhya.revisionv3.network.PojoClasses.PQustnPaper;
import com.android.alekhya.revisionv3.R;

import java.util.ArrayList;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class PQustnpaperAdapter extends RecyclerView.Adapter<PQustnpaperAdapter.ViewHolder> {
    private ArrayList<PQustnPaper> android;

    public PQustnpaperAdapter(ArrayList<PQustnPaper> android) {
        this.android = android;
    }

    @Override
    public PQustnpaperAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PQustnpaperAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(android.get(i).getFilename());
        BaseApplication.url=android.get(i).getP_name();
        BaseApplication.filename = android.get(i).getFilename();
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(),DisplayPDF.class));
                }
            });
        }
    }

}
