package com.android.alekhya.revisionv3.quiz;

/**
 * Created by Alekhya on 07-03-2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.alekhya.revisionv3.R;


public class QuizMainactivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.quizactivity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);


            Button btnStart = findViewById(R.id.btnStart);
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent conceptIntent=new Intent(QuizMainactivity.this,ConceptActivity.class);
                    startActivity(conceptIntent);

                }
            });

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            return true;
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Handle the camera action
            } else if (id == R.id.nav_quizone) {
                Intent conceptIntent=new Intent(QuizMainactivity.this,ConceptActivity.class);
                startActivity(conceptIntent);
            } else if (id == R.id.nav_quiztwo) {

            }else if (id == R.id.nav_quizthree) {

            }else if (id == R.id.nav_quizfour) {

            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

