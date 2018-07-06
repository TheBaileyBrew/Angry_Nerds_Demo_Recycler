package com.thebaileybrew.angry_nerds_demo_recycler;

import java.util.ArrayList;

public class NerdsDatabase extends ArrayList {
    private ArrayList<AngryNerd> NerdDatabase = new ArrayList<>();

    public ArrayList getNerds() {
        NerdDatabase.add(new AngryNerd("Matthew", "News App Pt. 2", 1));
        NerdDatabase.add(new AngryNerd("Olivia", "News App Pt. 1", 2));
        NerdDatabase.add(new AngryNerd("Chris", "Inventory", 3));
        NerdDatabase.add(new AngryNerd("Rosario", "Tour Guide", 4));
        NerdDatabase.add(new AngryNerd("Peter", "Tour Guide", 5));
        NerdDatabase.add(new AngryNerd("MacKenzie", "News App Pt. 2", 6));
        NerdDatabase.add(new AngryNerd("Tim", "Music Player", 7));
        NerdDatabase.add(new AngryNerd("Dave", "News App Pt. 2", 8));
        //More Angry_Nerds go here
        return NerdDatabase;
    }
}
