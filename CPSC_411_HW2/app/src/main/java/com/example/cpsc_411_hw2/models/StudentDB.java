package com.example.cpsc_411_hw2.models;

import java.util.ArrayList;

public class StudentDB {

    public static final StudentDB ourInstance = new StudentDB();
    public ArrayList<Student> mStudentList;


    static public StudentDB getInstance() {return ourInstance;}


    public StudentDB(){}

    public ArrayList<Student> getStudentList() { return mStudentList;}


    public void setStudentList (ArrayList<Student> sList) {mStudentList = sList;}


}
