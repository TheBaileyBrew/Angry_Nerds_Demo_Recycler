package com.thebaileybrew.angry_nerds_demo_recycler;

public class AngryNerd {

    private String NerdName;
    private String NerdProject;
    private int NerdId;

    public AngryNerd (String NerdName, String NerdProject, int NerdId) {
        this.NerdName = NerdName;
        this.NerdProject = NerdProject;
        this.NerdId = NerdId;
    }

    //These are your GETTERS to return the selected items
    public String getNerdName() {
        return NerdName;
    }
    public String getNerdProject() {
        return NerdProject;
    }
    public int getNerdId() {
        return NerdId;
    }
}
