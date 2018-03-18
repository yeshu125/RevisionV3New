package com.android.alekhya.revisionv3.network.PojoClasses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.Adapters.UnitAdapter;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Alekhya on 05-02-2018.
 */

public class TextBook extends AppCompatActivity{
    private RecyclerView recyclerView;
    private ArrayList<Unit> data;
    private UnitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.units);
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


        Call<Textbookpojo> call = RestApi.get().getRestService().getTextbookpojo(BaseApplication.subjectId);

        call.enqueue(new Callback<Textbookpojo>() {
            @Override
            public void onResponse(Call<Textbookpojo> call, retrofit2.Response<Textbookpojo> response) {
                Textbookpojo jsonResponse = response.body();
                data =(ArrayList<Unit>) jsonResponse.getUnit();
                adapter = new UnitAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Textbookpojo> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}