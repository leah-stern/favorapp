package edu.cs.tufts.irisoliver.favorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class search_favor extends AppCompatActivity {


    private Button artist, driver, handyperson, fish, clean, chef, tutor, translate, knitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_favor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        artist = (Button) findViewById(R.id.artist);

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artist_users = new Intent(search_favor.this, skilled_users.class);
                artist_users.putExtra("button_clicked", "artist");
                startActivity(artist_users);

               // finish();
            }

        });

        driver = (Button) findViewById(R.id.driver);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent driver_users = new Intent(search_favor.this, skilled_users.class);
                driver_users.putExtra("button_clicked", "driver");
                startActivity(driver_users);
            }

        });

        handyperson = (Button) findViewById(R.id.handyperson);

        handyperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent handyperson_users = new Intent(search_favor.this, skilled_users.class);
                handyperson_users.putExtra("button_clicked", "handyperson");
                startActivity(handyperson_users);
            }

        });

        fish = (Button) findViewById(R.id.fish);

        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fish_users = new Intent(search_favor.this, skilled_users.class);
                fish_users.putExtra("button_clicked", "fish");
                startActivity(fish_users);
            }

        });

        clean = (Button) findViewById(R.id.clean);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clean_users = new Intent(search_favor.this, skilled_users.class);
                clean_users.putExtra("button_clicked", "clean");
                startActivity(clean_users);
            }

        });

        chef = (Button) findViewById(R.id.chef);

        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chef_users = new Intent(search_favor.this, skilled_users.class);
                chef_users.putExtra("button_clicked", "chef");
                startActivity(chef_users);
            }

        });

        tutor = (Button) findViewById(R.id.tutor);

        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutor_users = new Intent(search_favor.this, skilled_users.class);
                tutor_users.putExtra("button_clicked", "tutor");
                startActivity(tutor_users);
            }

        });

        translate = (Button) findViewById(R.id.translate);

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent translate_users = new Intent(search_favor.this, skilled_users.class);
                translate_users.putExtra("button_clicked", "translate");
                startActivity(translate_users);
            }

        });

        knitter = (Button) findViewById(R.id.knitter);

        knitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textile_users = new Intent(search_favor.this, skilled_users.class);
                textile_users.putExtra("button_clicked", "textiles");
                startActivity(textile_users);
            }

        });

    }
}
