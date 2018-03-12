package com.android.alekhya.revisionv3.network.Adapters;

        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.android.alekhya.revisionv3.BaseApplication;
        import com.android.alekhya.revisionv3.Units;
        import com.android.alekhya.revisionv3.R;
        import com.android.alekhya.revisionv3.Videos;
        import com.android.alekhya.revisionv3.network.PojoClasses.MVedio;

        import java.util.ArrayList;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class VedioAdapter extends RecyclerView.Adapter<VedioAdapter.ViewHolder> {
    private ArrayList<MVedio> android;

    public VedioAdapter(ArrayList<MVedio> android) {
        this.android = android;
    }

    @Override
    public VedioAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VedioAdapter.ViewHolder viewHolder, int i) {

        BaseApplication.url=android.get(i).getVedios_name();
        BaseApplication.filename = android.get(i).getFilename();
        viewHolder.tv_api_level.setText(android.get(i).getFilename());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_api_level;
        public ViewHolder(View view) {
            super(view);

            tv_api_level = (TextView)view.findViewById(R.id.tv_header);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(),Videos.class));
                }
            });
        }
    }

}
