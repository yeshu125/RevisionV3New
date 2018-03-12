package com.android.alekhya.revisionv3.network;

import android.view.View;
import android.widget.TextView;

import com.android.alekhya.revisionv3.R;


public class SpinnerItemHolder extends AbstractViewHolder {

    public TextView txtItem;

    public SpinnerItemHolder(View v) {
        super(v);
        txtItem = (TextView) v.findViewById(R.id.txtSpinner);
    }

    public TextView getCountryName() {
        return txtItem;
    }
}
