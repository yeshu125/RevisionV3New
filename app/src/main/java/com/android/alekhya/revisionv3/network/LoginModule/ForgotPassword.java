package com.android.alekhya.revisionv3.network.LoginModule;

/**
 * Created by Alekhya on 25-02-2018.
 */

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Users;
import com.android.alekhya.revisionv3.network.RestApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class ForgotPassword extends Fragment implements
        OnClickListener {
    private static View view;
    private static EditText emailId;
    private static TextView submit, back;

    public ForgotPassword() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgotpassword_layout, container,
                false);
        initViews();
        setListeners();
        return view;
    }
    private void initViews() {
        emailId = view.findViewById(R.id.registered_emailid);
        submit = view.findViewById(R.id.forgot_button);
        back = view.findViewById(R.id.backToLoginBtn);
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);
            back.setTextColor(csl);
            submit.setTextColor(csl);
        } catch (Exception e) {
        }
    }
    private void setListeners() {
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:
                new LoginActivityMain().replaceLoginFragment();
                break;
            case R.id.forgot_button:
                submitButtonTask();
                break;
        }
    }
    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();
        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailId);
        if (getEmailId.equals("") || getEmailId.length() == 0)
            new CustomToast().Show_Toast(getActivity(), view,
                    "Please enter your Email Id.");
        else if (!m.find())
            new CustomToast().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");
        else {
            Call<Users> res = RestApi.get().getRestService().ForgetPassword(getEmailId);
            res.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, retrofit2.Response<Users> response) {
                    int i = response.body().getStatus();
                    if (i == 1) {
                        new LoginActivityMain().replaceResetFragment();
                    } else {
                        Toast.makeText(getActivity(), "Your Email Id is not registered in our system.",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Log.e("Insert Sem failed", t.toString());
                }

            });


        }
    }
}