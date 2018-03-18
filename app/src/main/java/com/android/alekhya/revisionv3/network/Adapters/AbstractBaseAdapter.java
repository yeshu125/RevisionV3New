package com.android.alekhya.revisionv3.network.Adapters;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.alekhya.revisionv3.network.AbstractViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseAdapter<T, V extends AbstractViewHolder> extends BaseAdapter {
    protected final Context mContext;
    protected List<T> mList;
    private List<T> mOriginalList = new ArrayList<>();
    private SparseBooleanArray mSelectedItemsIds;
    private String myNumber;
    public AbstractBaseAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
        mSelectedItemsIds = new SparseBooleanArray();
    }
    public void addItems(List<T> list) {
        mList = new ArrayList<>(list);
        if (mOriginalList.isEmpty()) {
            mOriginalList = new ArrayList<>(list);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public T getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        V holder;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
            holder = getViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (V) view.getTag();
        }
        bindView(position, holder, getItem(position));
        return view;
    }
    public abstract int getLayoutId();
    public abstract V getViewHolder(View convertView);
    public abstract void bindView(int position, V holder, T item);
}
