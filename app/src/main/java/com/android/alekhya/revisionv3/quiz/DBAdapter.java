package com.android.alekhya.revisionv3.quiz;

import android.util.Log;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.network.PojoClasses.Questn;
import com.android.alekhya.revisionv3.network.PojoClasses.QuizQuestion;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

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
        Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions(BaseApplication.subjectId);
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
