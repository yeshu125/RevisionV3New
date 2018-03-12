package com.android.alekhya.revisionv3.quiz;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.network.PojoClasses.Questn;
import com.android.alekhya.revisionv3.network.PojoClasses.QuizQuestion;
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

    Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions("5");
   // Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions(BaseApplication.subjectId);
    Questions.enqueue(new Callback<QuizQuestion>() {
        @Override
        public void onResponse(Call<QuizQuestion> call, Response<QuizQuestion> response) {
            /*  for (Questn ques:response.body().getQuestn()) {
                  QuizQuestion quest = new QuizQuestion();
                  quest.setId(cursor.getInt(0));
                  quest.setQUESTION(cursor.getString(1));
                  quest.setANSWER(cursor.getString(2));
                  quest.setOptionA(cursor.getString(3));
                  quest.setOptionB(cursor.getString(4));
                  quest.setOptionC(cursor.getString(5));
                  quest.setOptionD(cursor.getString(6));


                  quesList.add(quest);
              }*/
            if (response.body().getQuestn().size()>0 ) {
                quesList.addAll(response.body().getQuestn());
            }
        }

        @Override
        public void onFailure(Call<QuizQuestion> call, Throwable t) {

        }
    });


        return quesList;
    }
}
