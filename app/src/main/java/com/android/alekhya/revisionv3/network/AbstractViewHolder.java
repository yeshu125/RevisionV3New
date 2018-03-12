package com.android.alekhya.revisionv3.network;

import android.view.View;

import butterknife.ButterKnife;


public abstract class AbstractViewHolder {

    private final View view;

    public AbstractViewHolder(View view) {
        this.view = view;
        ButterKnife.bind(this, view);




    }

    public View getRootView() {
        return view;
    }
}
