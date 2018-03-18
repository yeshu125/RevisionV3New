package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.Units;
import com.android.alekhya.revisionv3.network.PojoClasses.Unit;

import java.util.ArrayList;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.ViewHolder> {
    private ArrayList<Unit> android;
    public UnitAdapter(ArrayList<Unit> android) {
        this.android = android;
    }
    @Override
    public UnitAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(UnitAdapter.ViewHolder viewHolder, int i) {
        BaseApplication.url=android.get(i).getU_name();
        BaseApplication.filename = android.get(i).getFilename();
        viewHolder.tv_name.setText(BaseApplication.filename);
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
                    view.getContext().startActivity(new Intent(view.getContext(),Units.class));
                }
            });
        }
    }
}
