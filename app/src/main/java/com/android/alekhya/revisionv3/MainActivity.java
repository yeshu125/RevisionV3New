package com.android.alekhya.revisionv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.alekhya.revisionv3.network.PojoClasses.TextBook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        Button PQustn = (Button) findViewById(R.id.button2);
        PQustn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PQustn.class);
                startActivity(intent);

            }

        });
        Button Textbook = (Button) findViewById(R.id.button3);
        Textbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent1 = new Intent(view.getContext(), TextBook.class);
               // startActivityForResult(myIntent1, 0);
                //   Uri intentUri = Uri.parse("http://www.pdf995.com/samples/pdf.pdf");

              //  Intent intent = new Intent();
                //  intent.setAction(Intent.ACTION_VIEW);
                //  intent.setData(intentUri);

                startActivity(myIntent1);
            }

        });

        Button Media = (Button) findViewById(R.id.button4);
        Media.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent2 = new Intent(view.getContext(), Media.class);
                startActivity(myIntent2);
            }

        });

    }

}


