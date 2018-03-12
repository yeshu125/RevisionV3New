package com.android.alekhya.revisionv3.network.LoginModule;

/**
 * Created by Alekhya on 25-02-2018.
 */



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.alekhya.revisionv3.ActivityMain;
import com.android.alekhya.revisionv3.R;
import com.android.alekhya.revisionv3.network.PojoClasses.Users;
import com.android.alekhya.revisionv3.network.RestApi;

import retrofit2.Call;
import retrofit2.Callback;

public class SignupActivity extends Fragment implements OnClickListener {
    private static View view;
    private static EditText firstName,lastName, emailId, userName, password, confirmPassword;
    private static TextView login;
    private static Button signUpButton;
    private static CheckBox terms_conditions;

    public SignupActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_layout, container, false);
        initViews();
        setListeners();
        return view;
    }

    // Initialize all views
    private void initViews() {
        firstName = (EditText) view.findViewById(R.id.firstname);
        lastName = (EditText) view.findViewById(R.id.lastname);
        userName = (EditText) view.findViewById(R.id.username);
        emailId = (EditText) view.findViewById(R.id.userEmailId);
        password = (EditText) view.findViewById(R.id.password);
        confirmPassword = (EditText) view.findViewById(R.id.confirmPassword);
        signUpButton = (Button) view.findViewById(R.id.signUpBtn);
        login = (TextView) view.findViewById(R.id.already_user);
        terms_conditions = (CheckBox) view.findViewById(R.id.terms_conditions);

        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            login.setTextColor(csl);
            terms_conditions.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    // Set Listeners
    private void setListeners() {
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:

                // Call checkValidation method
                checkValidation();
                break;

            case R.id.already_user:

                // Replace login fragment
                new LoginActivityMain().replaceLoginFragment();
                break;
        }

    }

    // Check Validation Method
    private void checkValidation() {

        // Get all edittext texts
        String getFirstName = firstName.getText().toString();
        String getLastName = lastName.getText().toString();
        String getUserName = userName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getPassword = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();

        // Pattern match for email id
        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailId);

        // Check if all strings are null or not
        if (getFirstName.equals("") || getFirstName.length() == 0
                || getLastName.equals("")|| getLastName.length() == 0
                || getEmailId.equals("") || getEmailId.length() == 0
                || getUserName.equals("")|| getUserName.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0)

            new CustomToast().Show_Toast(getActivity(), view,
                    "All fields are required.");

            // Check if email id valid or not
        else if (!m.find())
            new CustomToast().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");

            // Check if both password should be equal
        else if (!getConfirmPassword.equals(getPassword))
            new CustomToast().Show_Toast(getActivity(), view,
                    "Both password doesn't match.");

            // Make sure user should check Terms and Conditions checkbox
        else if (!terms_conditions.isChecked())
            new CustomToast().Show_Toast(getActivity(), view,
                    "Please select Terms and Conditions.");

            // Else do signup or do your stuff
        else {
            Call<Users> res = RestApi.get().getRestService().registerUser(getUserName,getPassword,getEmailId,getFirstName,getLastName);
            res.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, retrofit2.Response<Users> response) {
                    int i =response.body().getStatus();
                    if ( i == 1) {
                        Intent intent = new Intent(view.getContext(), ActivityMain.class);
                        startActivity(intent);
                    } else {
                        new CustomToast().Show_Toast(getActivity(), view,
                                "Your Email Id/password is Invalid."+response.body().getStatus());
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