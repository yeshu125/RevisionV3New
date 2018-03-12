package com.android.alekhya.revisionv3.quiz;

import android.util.Log;

import com.android.alekhya.revisionv3.ActivityMain;
import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.network.Adapters.SpinnerSemAdapter;
import com.android.alekhya.revisionv3.network.PojoClasses.Questn;
import com.android.alekhya.revisionv3.network.PojoClasses.QuizQuestion;
import com.android.alekhya.revisionv3.network.PojoClasses.Sems;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alekhya on 07-03-2018.
 */

class DBAdapter {

    public int rowCount()
    {
        int row=0;

        return row;
    }

    public List<Questn> getAllQuestions() {

        final List<Questn> quesList = new ArrayList<Questn>();
        // Select All Query


   // Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions(BaseApplication.subjectId);
        Call<Sems> getSems = RestApi.get().getRestService().getSemesters();
        getSems.enqueue(new Callback<Sems>() {
            @Override
            public void onResponse(Call<Sems> call, retrofit2.Response<Sems> response) {
                Log.e("Insert Student Sem", response.toString());
                if (response.body().getSem().size() > 0) {
                    Log.e("PipeSize", response.body().toString());

                } else {
                    Log.e("dpsize False response", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Sems> call, Throwable t) {
                Log.e("Insert Sem failed", t.toString());
            }
        });
    Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions("5");
    Questions.enqueue(new Callback<QuizQuestion>() {
        @Override
        public void onResponse(Call<QuizQuestion> call, retrofit2.Response<QuizQuestion> response) {
            if (response.body().getQuestn().size()>0 ) {
                quesList.addAll(response.body().getQuestn());
            }
        }

        @Override
        public void onFailure(Call<QuizQuestion> call, Throwable t) {

            Log.e("exception",""+t.toString());
        }
    });


        return quesList;
    }
}
