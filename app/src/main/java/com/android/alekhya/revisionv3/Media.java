package com.android.alekhya.revisionv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.alekhya.revisionv3.quiz.QuizMainactivity;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class Media extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.media);
    Button MediaImage = findViewById(R.id.btnImages);
    MediaImage.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MediaImage.class);
            startActivity(intent);
        }

    });
    Button MediaVedio = findViewById(R.id.btnVideos);
    MediaVedio.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent1 = new Intent(view.getContext(), MediaVideo.class);
            startActivity(myIntent1);
        }

    });
    Button MediaQuiz = findViewById(R.id.btnQuiz);
    MediaQuiz.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent2 = new Intent(view.getContext(), QuizMainactivity.class);
            startActivity(myIntent2);
        }

    });

}}