package com.example.cpsc_411_hw2.models;

import java.util.ArrayList;

public class StudentDB {

    public static final StudentDB ourInstance = new StudentDB();
    public ArrayList<Student> mStudentList;

    static public StudentDB getInstance() {return ourInstance;}


    public StudentDB(){
        createStudentObject();
    }

    public ArrayList<Student> getStudentList() { return mStudentList;}

    public void setStudentList (ArrayList<Student> sList) {mStudentList = sList;}

    public void addToStudentList(Student student)
    {
        StudentDB.getInstance().mStudentList.add(student);
    }

    private void createStudentObject(){

        Student studentObject;
        ArrayList<Courses> courses = new ArrayList<Courses>();

        studentObject = new Student("Sami", "Halwani", "889586194");
        courses.add(new Courses("CPSC411", "A+"));
        courses.add(new Courses("CPSC481", "A"));
        mStudentList = new ArrayList<Student>();
        mStudentList.add(studentObject);

        studentObject = new Student("Priscella", "Zatar", "123456789");
        courses = new ArrayList<>();
        courses.add(new Courses("LAW999", "A+++"));
        courses.add(new Courses("LAW998", "A++"));
        studentObject.setCourses(courses);
        mStudentList.add(studentObject);
    }


}
