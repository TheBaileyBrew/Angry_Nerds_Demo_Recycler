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
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Sort ArrayList By Search

public class FragmentThree extends Fragment implements View.OnClickListener {
    NerdsDatabase array_of_nerds = new NerdsDatabase();
    ArrayList<AngryNerd> NerdDatabase = new ArrayList<>();
    ArrayList<AngryNerd> CustomDatabase = new ArrayList<>();
    ArrayList<AngryNerd> SearchDatabase = new ArrayList<>();
    AngryNerdAdapter adapterDefault;
    AngryNerdAdapter adapterCustom;
    EditText searchValue;
    String searchingText;

    public static FragmentThree newInstance() {
        FragmentThree fragment = new FragmentThree();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView defaultRecycler = rootView.findViewById(R.id.default_view);
        RecyclerView customRecycler = rootView.findViewById(R.id.custom_view);
        LinearLayout searchBar = rootView.findViewById(R.id.search_view);
        Button activityButton = rootView.findViewById(R.id.button_to_activity_view);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(getContext(), RecyclerOnActivity.class);
                startActivity(openActivity);
            }
        });
        searchBar.setVisibility(View.VISIBLE);
        Button searchButton = rootView.findViewById(R.id.submit_search);
        searchValue = rootView.findViewById(R.id.search_criteria);
        searchButton.setOnClickListener(this);
        NerdDatabase.clear();
        CustomDatabase.clear();
        if (array_of_nerds.getNerds() != null) {
            NerdDatabase = array_of_nerds.getNerds();
            CustomDatabase = NerdDatabase;
        }
        //Create your LinearLayoutManager with your context
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        //Create your adapter based on the custom class you created
        adapterDefault = new AngryNerdAdapter(getContext(), NerdDatabase);
        adapterCustom = new AngryNerdAdapter(getContext(), SearchDatabase);
        //Set your LayoutManager and Adapter
        defaultRecycler.setLayoutManager(linearLayoutManager);
        defaultRecycler.setAdapter(adapterDefault);
        customRecycler.setLayoutManager(linearLayoutManager2);
        customRecycler.setAdapter(adapterCustom);
        adapterDefault.notifyDataSetChanged();
        adapterCustom.notifyDataSetChanged();

        return rootView;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        searchingText = searchValue.getText().toString();
        SearchDatabase.clear();
        //This method takes your search input, and returns it as the displayed ArrayList
        for (AngryNerd nerd : CustomDatabase) {
            if(nerd.getNerdName().contains(searchingText)) {
                SearchDatabase.add(nerd);
            }
        }
        adapterCustom.notifyDataSetChanged();
    }
}
