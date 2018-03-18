package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.view.View;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Reg;
import com.android.alekhya.revisionv3.network.SpinnerItemHolder;

public class SpinnerRegAdapter extends AbstractBaseAdapter<Reg, SpinnerItemHolder> {
    public SpinnerRegAdapter(Context context) {
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
    public void bindView(int position, SpinnerItemHolder holder, Reg item) {
        holder.getCountryName().setText(item.getregulation_name());
    }
}
