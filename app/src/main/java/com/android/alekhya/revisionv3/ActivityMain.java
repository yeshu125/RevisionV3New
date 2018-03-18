package com.android.alekhya.revisionv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.android.alekhya.revisionv3.network.Adapters.SpinnerCourseAdapter;
import com.android.alekhya.revisionv3.network.Adapters.SpinnerRegAdapter;
import com.android.alekhya.revisionv3.network.Adapters.SpinnerSemAdapter;
import com.android.alekhya.revisionv3.network.Adapters.SpinnerSubjectAdapter;
import com.android.alekhya.revisionv3.network.Adapters.SpinnerYearAdapter;
import com.android.alekhya.revisionv3.network.PojoClasses.Course;
import com.android.alekhya.revisionv3.network.PojoClasses.Courses;
import com.android.alekhya.revisionv3.network.PojoClasses.Reg;
import com.android.alekhya.revisionv3.network.PojoClasses.Regulations;
import com.android.alekhya.revisionv3.network.PojoClasses.Sem;
import com.android.alekhya.revisionv3.network.PojoClasses.Sems;
import com.android.alekhya.revisionv3.network.PojoClasses.Subject;
import com.android.alekhya.revisionv3.network.PojoClasses.Subjects;
import com.android.alekhya.revisionv3.network.PojoClasses.Year;
import com.android.alekhya.revisionv3.network.PojoClasses.Years;
import com.android.alekhya.revisionv3.network.RestApi;
import com.android.alekhya.revisionv3.network.SessionManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by Alekhya on 04-02-2018.
 */

public class ActivityMain extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener,View.OnClickListener {
    Spinner regspin, coursespin, yearspin, semspin, subjectspin;
    String regulation, course,year, sem, subject;
    List<Reg> RegResponseList;
    List<Course> CourseResponseList;
    List<Year> YearResponseList;
    List<Sem> SemResponseList;
    List<Subject> SubjectResponseList;
    SpinnerRegAdapter RegAdapter;
    SpinnerCourseAdapter CourseAdapter;
    SpinnerYearAdapter YearAdapter;
    SpinnerSemAdapter SemAdapter;
    SpinnerSubjectAdapter SubjectAdapter;
    Button btnsubmit, btnLogout;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regspin = findViewById(R.id.regulation);
        coursespin = findViewById(R.id.course);
        yearspin = findViewById(R.id.year);
        semspin = findViewById(R.id.sem);
        subjectspin = findViewById(R.id.subject);
        btnsubmit = findViewById(R.id.button);
        btnLogout = findViewById(R.id.btnlogout);
        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManager.KEY_NAME);

        // email
        String email = user.get(SessionManager.KEY_EMAIL);

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                SharedPreferences mPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.remove("UserName");
                editor.remove("PassWord");
                editor.commit();

                finish();
            }
        });
        getReg();
        btnsubmit.setOnClickListener(this);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseApplication.subjectId =  subject;
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }

        });

        regspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                regulation = ((Reg) item).getregulation_id();
                getCourses();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        coursespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                course = ((Course) item).getCourse_id();
                getYear();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        yearspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                year = ((Year) item).gety_id();
                getSems();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        semspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                sem = ((Sem) item).getSem_id();
                getSubjects();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        subjectspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                subject = ((Subject) item).getSub_id();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void getReg() {
        Call<Regulations> getRegs = RestApi.get().getRestService().getRegulations();
        getRegs.enqueue(new Callback<Regulations>() {
            @Override
            public void onResponse(Call<Regulations> call, retrofit2.Response<Regulations> response) {
                Log.e("Reg response", response.toString());
                if (response.body().getReg().size() > 0) {
                    RegResponseList = response.body().getReg();
                    RegAdapter = new SpinnerRegAdapter(ActivityMain.this);
                    RegAdapter.addItems(RegResponseList);
                    regspin.setAdapter(RegAdapter);
                }
            }
            @Override
            public void onFailure(Call<Regulations> call, Throwable t) {
                Log.e("Reg failed", t.toString());
            }

        });
    }

    private void getCourses() {
        Call<Courses> getSems = RestApi.get().getRestService().getCourses();
        getSems.enqueue(new Callback<Courses>() {
            @Override
            public void onResponse(Call<Courses> call, retrofit2.Response<Courses> response) {
                Log.e("Course response", response.toString());
                if (response.body().getCourse().size() > 0) {
                    CourseResponseList = response.body().getCourse();
                    CourseAdapter = new SpinnerCourseAdapter(ActivityMain.this);
                    CourseAdapter.addItems(CourseResponseList);
                    coursespin.setAdapter(CourseAdapter);
                }
            }
            @Override
            public void onFailure(Call<Courses> call, Throwable t) {
                Log.e("Course failed", t.toString());
            }

        });
    }

    public void getYear() {
        Call<Years> getYears = RestApi.get().getRestService().getYears();
        getYears.enqueue(new Callback<Years>() {
            @Override
            public void onResponse(Call<Years> call, retrofit2.Response<Years> response) {
                Log.e("Year response", response.toString());
                if (response.body().getYear().size() > 0) {
                    YearResponseList = response.body().getYear();
                    YearAdapter = new SpinnerYearAdapter(ActivityMain.this);
                    YearAdapter.addItems(YearResponseList);
                    yearspin.setAdapter(YearAdapter);

                } else {
                    Log.e("Year not found", response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Years> call, Throwable t) {
                Log.e("Year response failed", t.toString());
            }
        });
    }

    private void getSems() {
        Call<Sems> getSems = RestApi.get().getRestService().getSemesters();
        getSems.enqueue(new Callback<Sems>() {
            @Override
            public void onResponse(Call<Sems> call, retrofit2.Response<Sems> response) {
                Log.e("Sem response", response.toString());
                if (response.body().getSem().size() > 0) {
                    SemResponseList = response.body().getSem();
                    SemAdapter = new SpinnerSemAdapter(ActivityMain.this);
                    SemAdapter.addItems(SemResponseList);
                    semspin.setAdapter(SemAdapter);
                } else {
                    Log.e("sem response failed", response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Sems> call, Throwable t) {
                Log.e("Sem response failed", t.toString());
            }

        });
    }

    private void getSubjects() {
        Log.e("Subjects inputs",regulation +""+course +""+year +""+ sem );
        Call<Subjects> getSubjects = RestApi.get().getRestService().getSubjects(regulation,course,year, sem);
        getSubjects.enqueue(new Callback<Subjects>() {
            @Override
            public void onResponse(Call<Subjects> call, retrofit2.Response<Subjects> response) {
                Log.e(" Subject response", response.toString());
                if (response.body().getSubject().size() > 0) {
                    SubjectResponseList = response.body().getSubject();
                    SubjectAdapter = new SpinnerSubjectAdapter(ActivityMain.this);
                    SubjectAdapter.addItems(SubjectResponseList);
                    subjectspin.setAdapter(SubjectAdapter);
                } else {
                    Log.e("Subject response", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Subjects> call, Throwable t) {
                Log.e("Subject failed", t.toString());
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()) {

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {

    }
}


