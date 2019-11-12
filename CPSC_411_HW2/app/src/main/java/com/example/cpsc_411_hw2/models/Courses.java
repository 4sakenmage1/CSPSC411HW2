package com.example.cpsc_411_hw2.models;

public class Courses {
    protected String mCourseID;
    protected String mGrade;

    public Courses (String cid, String g){

        mCourseID = cid;
        mGrade = g;
    }

    public String getCourseID(){return mCourseID;}

    public void setCourseID (String cid){mCourseID = cid; }

    public String getmGrade () {return mGrade;}

    public void setGrade (String g) {mGrade = g;}


}
