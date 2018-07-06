package com.thebaileybrew.angry_nerds_demo_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecyclerOnActivity extends AppCompatActivity {
    protected ArrayList<AngryNerd> NerdDatabase;
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fragmentButton = findViewById(R.id.button_to_fragment_view);
        fragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openFragment = new Intent(RecyclerOnActivity.this, RecyclerOnFragments.class);
                startActivity(openFragment);
            }
        });

        //Call your custom class and return your ArrayList data
        NerdsDatabase array_of_nerds = new NerdsDatabase();
        if (array_of_nerds.getNerds() != null) {
            NerdDatabase = array_of_nerds.getNerds();
        } else {
            NerdDatabase = new ArrayList<>();
        }

        //Create a standard LinearLayout Manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //Create an adapter based on the custom class you created
        AngryNerdAdapter angryAdapter = new AngryNerdAdapter(this,NerdDatabase);

        //Find your Recycler and set your layoutManger and adapter to it
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(angryAdapter);



    }
}
