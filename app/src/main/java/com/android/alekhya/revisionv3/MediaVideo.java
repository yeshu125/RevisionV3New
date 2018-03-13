package com.android.alekhya.revisionv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.alekhya.revisionv3.network.Adapters.VedioAdapter;
import com.android.alekhya.revisionv3.network.PojoClasses.MVedio;
import com.android.alekhya.revisionv3.network.PojoClasses.Vediopojo;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Alekhya on 05-02-2018.
 */

public class MediaVideo extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MVedio> data;
    private VedioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vedios);
        initViews();
    }
    private void initViews(){
        recyclerView = findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){


        Call<Vediopojo> call = RestApi.get().getRestService().getVediopojo(BaseApplication.subjectId);

        call.enqueue(new Callback<Vediopojo>() {
            @Override
            public void onResponse(Call<Vediopojo> call, retrofit2.Response<Vediopojo> response) {
                Vediopojo jsonResponse = response.body();
                data =(ArrayList<MVedio>) jsonResponse.getVedios();
                adapter = new VedioAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Vediopojo> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}