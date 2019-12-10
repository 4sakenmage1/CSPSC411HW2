package com.example.cpsc_411_hw2.models;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class StudentDB extends Activity {

    File database;
    private static SQLiteDatabase sqlDB;

    public StudentDB(Context context) {
        database = context.getDatabasePath("student.db");
        sqlDB = SQLiteDatabase.openOrCreateDatabase(database, null);

        String sqlQ = "CREATE TABLE IF NOT EXISTS STUDENT (FirstName Text, LastName Text, CWID Text)";
        sqlDB.execSQL(sqlQ);

        sqlQ = "CREATE TABLE IF NOT EXISTS COURSES (CWID Text, Course Text, Grade Text)";
        sqlDB.execSQL(sqlQ);

    }

    // Retrieves the database student list
    public static ArrayList<Student> getStudentList() {
        ArrayList<Student> sList = new ArrayList<>();
        Student s;
        ArrayList<Courses> courses = new ArrayList<>();
        Cursor curr = sqlDB.query("STUDENT", null, null,
                null, null, null, null);
        if(curr.getCount() > 0) {
            while(curr.moveToNext()) {
                s = new Student(curr.getString(0), curr.getString(1), curr.getString(2));

                Cursor curr2 = sqlDB.query("COURSES", null, "CWID=?",
                        new String[]{curr.getString(2)}, null, null, null);

                if(curr2.getCount() > 0) {
                    courses = new ArrayList<>();
                    while(curr2.moveToNext()) {
                        courses.add(new Courses(curr2.getString(1), curr2.getString(2)));
                    }
                }
                s.setCourses(courses);
                sList.add(s);
            }
        }
        return sList;
    }

    // Add full list of students to the database
    public static void addListToDB(ArrayList<Student> studentList) {
        for(Student student:studentList){
            sqlDB.execSQL("INSERT INTO STUDENT VALUES (?, ?, ?)", new String[]{student.getFirstName(),
                    student.getLastName(), student.getCWID()});

            for(Courses course:student.getCourses()) {
                sqlDB.execSQL("INSERT INTO COURSES VALUES (?, ?, ?)", new String[]{student.getCWID(),
                        course.getCourseID(), course.getmGrade()});
            }
        }
    }
    public static void updateDB(Student updatedStudent) {
        ContentValues cv = new ContentValues();
        cv.put("FirstName", updatedStudent.getFirstName());
        cv.put("LastName", updatedStudent.getLastName());
        sqlDB.update("STUDENT", cv, "CWID=?", new String[]{updatedStudent.getCWID()});
    }
}
