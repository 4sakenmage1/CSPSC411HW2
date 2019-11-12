package com.example.cpsc_411_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);


        root  = findViewById(R.id.student_list);


        ArrayList<Student> studentList = StudentDB.getInstance().getStudentList();

        for(int i = 0 ; i <studentList.size(); i++)
        {
            Student s = studentList.get(i);




        }


    }
}
