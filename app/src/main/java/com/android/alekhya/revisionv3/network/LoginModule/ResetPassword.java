package com.android.alekhya.revisionv3.network.LoginModule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.alekhya.revisionv3.ActivityMain;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Users;
import com.android.alekhya.revisionv3.network.RestApi;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by kkothagundu on 3/18/2018.
 */

public class ResetPassword extends Fragment implements View.OnClickListener {
    private static View view;
    private static EditText emailId, password, confirmPassword;
    private static Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.resetpassword, container, false);
        initViews();
        return view;
    }

    // Initialize all views
    private void initViews() {
        emailId = view.findViewById(R.id.registered_emailid);
        password = view.findViewById(R.id.password);
        confirmPassword = view.findViewById(R.id.confirmPassword);
        submitButton = view.findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(this);

        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);
        } catch (Exception e) {
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:

                // Call checkValidation method
                checkValidation();
                break;
        }

    }

    // Check Validation Method
    private void checkValidation() {

        // Get all edittext texts
        String getPassword = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();
        String getEmailId = emailId.getText().toString();


        // Check if all strings are null or not
        if (getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0)

            new CustomToast().Show_Toast(getActivity(), view,
                    "All fields are required.");

            // Check if email id valid or not
        else if (!getConfirmPassword.equals(getPassword))
            new CustomToast().Show_Toast(getActivity(), view,
                    "Both password doesn't match.");
        else {
            Call<Users> res = RestApi.get().getRestService().ResetPassword(getEmailId, getPassword);
            res.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, retrofit2.Response<Users> response) {
                    int i = response.body().getStatus();
                    if (i == 1) {
                        Intent intent = new Intent(view.getContext(), ActivityMain.class);
                        startActivity(intent);
                    } else {
                        new CustomToast().Show_Toast(getActivity(), view,
                                "Your Email Id/password is Invalid." + response.body().getStatus());
                    }
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Log.e("Insert User failed", t.toString());
                }
            });
        }
    }
}
