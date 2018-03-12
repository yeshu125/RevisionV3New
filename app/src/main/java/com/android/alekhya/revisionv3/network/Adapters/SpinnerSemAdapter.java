package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.view.View;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Sem;
import com.android.alekhya.revisionv3.network.SpinnerItemHolder;


public class SpinnerSemAdapter extends AbstractBaseAdapter<Sem, SpinnerItemHolder> {
    public SpinnerSemAdapter(Context context) {
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
    public void bindView(int position, SpinnerItemHolder holder, Sem item) {
        //Sem obj=new Sem();
        //obj = item.getSem().get(position);
        holder.getCountryName().setText(item.getSem_name());
    }
}
