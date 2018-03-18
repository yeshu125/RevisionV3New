package com.android.alekhya.revisionv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.alekhya.revisionv3.network.Adapters.ImageAdapter;
import com.android.alekhya.revisionv3.network.PojoClasses.Imagepojo;
import com.android.alekhya.revisionv3.network.PojoClasses.MImage;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Alekhya on 05-02-2018.
 */

public class MediaImage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MImage> data;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images);
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
        Call<Imagepojo> call = RestApi.get().getRestService().getImagepojo(BaseApplication.subjectId);
        call.enqueue(new Callback<Imagepojo>() {
            @Override
            public void onResponse(Call<Imagepojo> call, retrofit2.Response<Imagepojo> response) {
                Imagepojo jsonResponse = response.body();
                data =(ArrayList<MImage>) jsonResponse.getImage();
                adapter = new ImageAdapter(data);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<Imagepojo> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}