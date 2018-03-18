package com.android.alekhya.revisionv3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.alekhya.revisionv3.network.PojoClasses.TextBook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        Button PQustn = findViewById(R.id.button2);
        PQustn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PQustn.class);
                startActivity(intent);
            }

        });
        Button Textbook = findViewById(R.id.button3);
        Textbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent1 = new Intent(view.getContext(), TextBook.class);
                startActivity(myIntent1);
            }

        });
        Button Media = findViewById(R.id.button4);
        Media.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent2 = new Intent(view.getContext(), Media.class);
                startActivity(myIntent2);
            }

        });
        Button btnLogout = findViewById(R.id.btnlogout);
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

    }

}


