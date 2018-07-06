package com.thebaileybrew.angry_nerds_demo_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Sort ArrayList By Shuffle

public class FragmentTwo extends Fragment {
    NerdsDatabase array_of_nerds = new NerdsDatabase();
    NerdsDatabase array_of_nerds2 = new NerdsDatabase();
    ArrayList<AngryNerd> NerdDatabase = new ArrayList<>();
    ArrayList<AngryNerd> CustomDatabase = new ArrayList<>();

    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView defaultRecycler = rootView.findViewById(R.id.default_view);
        RecyclerView customRecycler = rootView.findViewById(R.id.custom_view);
        Button activityButton = rootView.findViewById(R.id.button_to_activity_view);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(getContext(), RecyclerOnActivity.class);
                startActivity(openActivity);
            }
        });
        NerdDatabase.clear();
        CustomDatabase.clear();
        NerdDatabase = array_of_nerds.getNerds();
        CustomDatabase = array_of_nerds2.getNerds();
        //This method takes your input CustomDatabase, and an object to compare
        Collections.shuffle(CustomDatabase);

        //Create your LinearLayoutManager with your context
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        //Create your adapter based on the custom class you created
        AngryNerdAdapter adapterDefault = new AngryNerdAdapter(getContext(), NerdDatabase);
        AngryNerdAdapter adapterCustom = new AngryNerdAdapter(getContext(), CustomDatabase);
        //Set your LayoutManager and Adapter
        defaultRecycler.setLayoutManager(linearLayoutManager);
        defaultRecycler.setAdapter(adapterDefault);
        customRecycler.setLayoutManager(linearLayoutManager2);
        customRecycler.setAdapter(adapterCustom);
        adapterDefault.notifyDataSetChanged();
        adapterCustom.notifyDataSetChanged();

        return rootView;
    }
}
