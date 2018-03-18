package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.view.View;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Course;
import com.android.alekhya.revisionv3.network.SpinnerItemHolder;

public class SpinnerCourseAdapter extends AbstractBaseAdapter<Course, SpinnerItemHolder> {
    public SpinnerCourseAdapter(Context context) {
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
    public void bindView(int position, SpinnerItemHolder holder, Course item) {
        holder.getCountryName().setText(item.getCourse_name());
    }
}
