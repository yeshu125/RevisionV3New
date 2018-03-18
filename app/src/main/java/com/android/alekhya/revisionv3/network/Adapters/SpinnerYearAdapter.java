package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.view.View;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Year;
import com.android.alekhya.revisionv3.network.SpinnerItemHolder;

public class SpinnerYearAdapter extends AbstractBaseAdapter<Year, SpinnerItemHolder> {

    public SpinnerYearAdapter(Context context) {
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
    public void bindView(int position, SpinnerItemHolder holder, Year item) {
        holder.getCountryName().setText(item.gety_name());
    }
}
