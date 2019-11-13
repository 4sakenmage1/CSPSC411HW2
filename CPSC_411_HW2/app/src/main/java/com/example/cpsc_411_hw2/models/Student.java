package com.example.cpsc_411_hw2.models;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected String mCWID;

    protected ArrayList<Courses> mCourses;

    public Student(String mFirstName, String mLastname, String mCWID){
        this.mFirstName = mFirstName;
        this.mLastName = mLastname;
        this.mCWID = mCWID;
    }


    public String getFirstName (){return mFirstName;}
    public void setFirstName(String fName) {mFirstName = fName;}

    public String getLastName() {
        return mLastName;
    }
    public void setLastName(String lName) {
        mLastName = lName;
    }

    public String getCWID () {return mCWID;}
    public void setCWID( String cid) {mCWID = cid;}

    public void setCourses(ArrayList<Courses> courses){mCourses = courses;}

}
