package com.thebaileybrew.angry_nerds_demo_recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<AngryNerd> NerdsDatabase = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create your ArrayList data
        NerdsDatabase.add(new AngryNerd("Matthew", "News App Pt. 1", 1));
        NerdsDatabase.add(new AngryNerd("Olivia", "Tour Guide", 2));
        NerdsDatabase.add(new AngryNerd("Chris", "News App Pt. 1", 3));

        //Create a standard LinearLayout Manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //Create an adapter based on the custom class you created
        AngryNerdAdapter angryAdapter = new AngryNerdAdapter(this,NerdsDatabase);

        //Find your Recycler and set your layoutManger and adapter to it
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(angryAdapter);



    }
}
