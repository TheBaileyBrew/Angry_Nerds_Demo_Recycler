package com.thebaileybrew.angry_nerds_demo_recycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public ArrayList<AngryNerd> NerdDatabase;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angry_nerds_selection);

        Button fragmentButton = findViewById(R.id.recycler_with_fragments);
        Button activityButton = findViewById(R.id.recycler_with_activities);
        fragmentButton.setOnClickListener(this);
        activityButton.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.recycler_with_fragments:
                Intent openFragments = new Intent(this,RecyclerOnFragments.class);
                startActivity(openFragments);
                break;
            case R.id.recycler_with_activities:
                Intent openActivity = new Intent(this,RecyclerOnActivity.class);
                startActivity(openActivity);
                break;
        }


    }
}
