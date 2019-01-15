package edu.cs.tufts.irisoliver.favorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.*;

public class skilled_users extends AppCompatActivity {

//    private ListView mListView;
//    inputEmail = (EditText) findViewById(R.id.email);

    private ListView user_list;
    private ArrayList<String>  user_IDs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skilled_users);

//        final DatabaseReference user_ref = FirebaseDatabase.getInstance().getReference("USERS");
        Intent pref_info = getIntent();
        final Bundle pref_data = pref_info.getExtras();
        assert (!pref_data.isEmpty());

        user_list = (ListView) findViewById(R.id.results);


        FirebaseDatabase.getInstance().getReference().child("USERS")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String user_type = pref_data.getString("button_clicked");

                        ArrayList<String> lst = new ArrayList<String>();


                        for (DataSnapshot new_snap : dataSnapshot.getChildren()) {

                            if (user_type.equals("artist")) {
                                if (new_snap.child("artist").getValue().toString() == "true") {
                                   lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("driver")) {
                                if (new_snap.child("driver").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("handyperson")) {
                                if (new_snap.child("handyperson").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }
//
//                            if (user_type.equals("repair")) {
//                                if (new_snap.child("repair").getValue().toString() == "true") {
//                                    lst.add(new_snap.child("name").getValue().toString());
//                                    user_IDs.add(new_snap.getKey());
//                                }
//                            }
//
                            if (user_type.equals("fish")) {
                                if (new_snap.child("pets").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("clean")) {
                                if (new_snap.child("cleaner").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("chef")) {
                                if (new_snap.child("chef").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("tutor")) {
                                if (new_snap.child("tutor").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("translate")) {
                                if (new_snap.child("translator").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }

                            if (user_type.equals("textiles")) {
                                if (new_snap.child("textiles").getValue().toString() == "true") {
                                    lst.add(new_snap.child("name").getValue().toString());
                                    user_IDs.add(new_snap.getKey());
                                }
                            }
                        }

                        if (lst.isEmpty()) {
                            lst.add("No users can do this skill! :( Check back again soon!");
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(skilled_users.this,
                                android.R.layout.simple_list_item_1, lst);

                        user_list.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        user_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                user_list.getItemAtPosition(i);

                Intent clicked_user = new Intent(skilled_users.this, User_profile.class);
                clicked_user.putExtra("user_ID", user_IDs.get(i));
                startActivity(clicked_user);
            }
        });


    };




//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


//                        String name = (String)dataSnapshot.child("users").getValue();
//                        Users list = dataSnapshot.child("Users");
//
//
//
////                      child(dataSnapshot.getKey()).child("name").getValue();
//                        DatabaseReference user_ref = FirebaseDatabase.getInstance().getReference("USERS");
//
//                        lst.add(name);
//
//                            String name = (String)dataSnapshot.child(curr_user).child("name").getValue();

//                        String name =  dataSnapshot.getKey();
//                        lst.add(name);
//                String name = (String)dataSnapshot.child("7DQYbmZrPCciKU9hW02hTPpLuRW2").child("name").getValue();

//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            String curr_user = snapshot.getKey();
//                            String name = snapshot.child(curr_user).child("name").getValue().toString();
////                            System.out.println(name);
//                            lst.add(name);
//                        }

//        user_ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String name = (String)dataSnapshot.child("7DQYbmZrPCciKU9hW02hTPpLuRW2").child("name").getValue();
//
//                String[] user_array = {name, "Bob", "FlavorFlav"};
//                ArrayList<String> lst = new ArrayList<String>(Arrays.asList(user_array));
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(skilled_users.this,
//                        android.R.layout.simple_list_item_1, lst);
//
//                user_list.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
