package com.example.cpsc_411_hw2.models;

import java.util.ArrayList;

public class CoursesDB {

    private static final CoursesDB ourInstance = new CoursesDB();

    private ArrayList<Courses> mCoursesList;

    static public CoursesDB getInstance(){
        return ourInstance;
    }

    private CoursesDB(){ }

    public ArrayList<Courses> getCoursesList() {
        return mCoursesList;
    }
    public void setCoursesList(ArrayList<Courses> coursesList){ mCoursesList = coursesList; }
}
