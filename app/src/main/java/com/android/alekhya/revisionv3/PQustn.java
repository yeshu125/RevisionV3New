package com.android.alekhya.revisionv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.alekhya.revisionv3.network.Adapters.PQustnpaperAdapter;
import com.android.alekhya.revisionv3.network.PojoClasses.PQustnPaper;
import com.android.alekhya.revisionv3.network.PojoClasses.PQustnpapers;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Alekhya on 05-02-2018.
 */

public class PQustn extends AppCompatActivity{
    private RecyclerView recyclerView;
    private ArrayList<PQustnPaper> data;
    private PQustnpaperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pqustn);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){


        Call<PQustnpapers> call = RestApi.get().getRestService().getPQustnpapers(BaseApplication.subjectId);

        call.enqueue(new Callback<PQustnpapers>() {
            @Override
            public void onResponse(Call<PQustnpapers> call, retrofit2.Response<PQustnpapers> response) {
                PQustnpapers jsonResponse = response.body();
                data =(ArrayList<PQustnPaper>) jsonResponse.getPaper();
                adapter = new PQustnpaperAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PQustnpapers> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}