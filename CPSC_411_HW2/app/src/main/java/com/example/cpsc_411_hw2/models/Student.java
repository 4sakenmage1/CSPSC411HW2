package com.example.cpsc_411_hw2.models;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected int mCWID;

    protected ArrayList<Courses> mCourses;

    public String getFirstName (){return mFirstName;}
    public void setFirstName(String fName) {mFirstName = fName;}

    public String getLastName() {
        return mLastName;
    }
    public void setLastName(String lName) {
        mLastName = lName;
    }

    public int getCWID () {return mCWID;}
    public void setCWID( int cid) {mCWID = cid;}

}