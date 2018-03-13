package com.android.alekhya.revisionv3.quiz;

/**
 * Created by Alekhya on 07-03-2018.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.OptionList;
import com.android.alekhya.revisionv3.network.PojoClasses.Options;
import com.android.alekhya.revisionv3.network.PojoClasses.Questn;
import com.android.alekhya.revisionv3.network.PojoClasses.QuizQuestion;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConceptActivity extends AppCompatActivity {

    ArrayList<String> myAnsList;
    Boolean validate = false;
    private List<Questn> questionsList;
    private Questn currentQuestion;
    private List<Options> currentOptions = new ArrayList<Options>();
    private Options currentOption = new Options();
    private TextView txtQuestion,tvNoOfQs;
    private RadioButton rbtnA, rbtnB, rbtnC,rbtnD;
    private Button btnNext;
    private int obtainedScore=0;
    private int questionId=0;
    private int answeredQsNo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);


        //Initialize the view
        init();

        //Initialize the database
        Call<QuizQuestion> Questions = RestApi.get().getRestService().getQuestions(BaseApplication.subjectId);
        Questions.enqueue(new Callback<QuizQuestion>() {
            @Override
            public void onResponse(Call<QuizQuestion> call, retrofit2.Response<QuizQuestion> response) {
                if (response.body().getQuestn().size() > 0) {
                    questionsList = response.body().getQuestn();
                    currentQuestion = questionsList.get(questionId);
                    validate = true;
                }
            }

            @Override
            public void onFailure(Call<QuizQuestion> call, Throwable t) {

                Log.e("exception",""+t.toString());
            }
        });

        //Call<OptionList> optionListCall = RestApi.get().getRestService().getOptions("5");
        Call<OptionList> optionListCall = RestApi.get().getRestService().getOptions(BaseApplication.subjectId);
        optionListCall.enqueue(new Callback<OptionList>() {
            @Override
            public void onResponse(Call<OptionList> call, Response<OptionList> response) {
                currentOptions.addAll(response.body().getOptions());
                currentOption = currentOptions.get(questionId);
                setQuestionsView();
            }

            @Override
            public void onFailure(Call<OptionList> call, Throwable t) {

            }
        });
        //Set question


        //Check and Next
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = findViewById(R.id.radioGroup1);
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

                Log.e("Answer ID", "Selected Positioned  value - "+grp.getCheckedRadioButtonId());

                if(answer!=null){
                    Log.e("Answer", currentOptions.get(questionId).getCorrect_answer() + " -- " + answer.getText());
                    //Add answer to the list

                    myAnsList.add(""+answer.getText());

                    if (currentOptions.get(questionId).getCorrect_answer().equals(answer.getText())) {
                        obtainedScore++;
                        Log.e("comments", "Correct Answer");
                        Log.d("score", "Obtained score " + obtainedScore);
                    }else{
                        Log.e("comments", "Wrong Answer=" + currentOptions.get(questionId).getCorrect_answer() + "questionId" + questionId);
                    }
                    questionId++;
                    if (questionsList.size() > questionId) {
                        currentQuestion=questionsList.get(questionId);
                        setQuestionsView();
                    }else{
                        Intent intent = new Intent(ConceptActivity.this, ResultActivity.class);

                        Bundle b = new Bundle();
                        b.putInt("score", obtainedScore);
                        b.putInt("totalQs", questionsList.size());
                        b.putStringArrayList("myAnsList", myAnsList);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();

                    }


                }else{
                    Log.e("comments", "No Answer");
                }

                //Need to clear the checked item id
                grp.clearCheck();


            }//end onClick Method
        });


    }

    public void init(){
        tvNoOfQs = findViewById(R.id.tvNumberOfQuestions);
        txtQuestion = findViewById(R.id.tvQuestion);
        rbtnA = findViewById(R.id.radio0);
        rbtnB = findViewById(R.id.radio1);
        rbtnC = findViewById(R.id.radio2);
        rbtnD = findViewById(R.id.radio3);

        btnNext = findViewById(R.id.btnNext);

        myAnsList = new ArrayList<String>();
    }


    private void setQuestionsView()
    {
        rbtnA.setChecked(false);
        rbtnB.setChecked(false);
        rbtnC.setChecked(false);
        rbtnD.setChecked(false);

        answeredQsNo=questionId+1;
        if (validate) {
            tvNoOfQs.setText("Questions " + answeredQsNo + " of " + questionsList.size());

            txtQuestion.setText(currentQuestion.getQuestion());
            rbtnA.setText(currentOptions.get(questionId).getOption1());
            rbtnC.setText(currentOptions.get(questionId).getOption2());
            rbtnD.setText(currentOptions.get(questionId).getOption3());
            rbtnB.setText(currentOptions.get(questionId).getOption4());

            //  questionId++;
        }
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
