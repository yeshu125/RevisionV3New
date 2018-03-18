package com.android.alekhya.revisionv3.quiz;

/**
 * Created by Alekhya on 07-03-2018.
*/

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.alekhya.revisionv3.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ArrayList<String> myAnsList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        RatingBar bar = findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        TextView tvAnsweredInfo = findViewById(R.id.tvAnsweredInfo);
        TextView t = findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        int totalQs= b.getInt("totalQs");
        myAnsList=b.getStringArrayList("myAnsList");
        bar.setRating(score);
        tvAnsweredInfo.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");
        float percentage=(score*100)/totalQs;
        if (percentage>=80 && percentage<=100){
            t.setText("Score is Excellent !");
        }else if(percentage>=70 && percentage<=79){
            t.setText("Score is Best");
        }else if(percentage>=60 && percentage<=69){
            t.setText("Score is Good");
        }else if(percentage>=50 && percentage<=59){
            t.setText("Score is Average!");
        }else if(percentage>=33 && percentage<=49){
            t.setText("Score is  Below Average!");
        }else{
            t.setText("Score is Poor! You need to practice more!");
        }
        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
