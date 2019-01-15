package edu.cs.tufts.irisoliver.favorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent get_ID = getIntent();
        final Bundle pref_data = get_ID.getExtras();
        assert (!pref_data.isEmpty());


        FirebaseDatabase.getInstance().getReference().child("USERS")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String user_ID = pref_data.getString("user_ID");
                        String name = (String)dataSnapshot.child(user_ID).child("name").getValue();
                        String email = (String)dataSnapshot.child(user_ID).child("email").getValue();

                        TextView name_text = (TextView) findViewById(R.id.name);
                        name_text.setText(name);

                        TextView email_text = (TextView) findViewById(R.id.email);
                        email_text.setText(email);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });


    }

}
