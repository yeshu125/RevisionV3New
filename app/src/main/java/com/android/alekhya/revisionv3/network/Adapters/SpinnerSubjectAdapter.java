package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.view.View;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Subject;
import com.android.alekhya.revisionv3.network.SpinnerItemHolder;


public class SpinnerSubjectAdapter extends AbstractBaseAdapter<Subject, SpinnerItemHolder> {

    public SpinnerSubjectAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.spinner_txt;
    }

    @Override
    public SpinnerItemHolder getViewHolder(View convertView) {
        return new SpinnerItemHolder(convertView);
    }

    @Override
    public void bindView(int position, SpinnerItemHolder holder, Subject item) {
        holder.getCountryName().setText("Select Year");
        holder.getCountryName().setText(item.getSub_name());
    }
}
