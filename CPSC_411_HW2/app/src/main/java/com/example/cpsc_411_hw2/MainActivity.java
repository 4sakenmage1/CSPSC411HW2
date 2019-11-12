package com.example.cpsc_411_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_rows, root, false);

            TextView fNameView = (TextView) row_view.findViewById(R.id.first_name);
            fNameView.setText(s.getFirstName());
            fNameView.setPadding(10,10,10,10);

            TextView lNameView = (TextView) row_view.findViewById(R.id.last_name);
            lNameView.setText(s.getLastName());
            lNameView.setPadding(10,10,10,10);

            TextView CWID = (TextView) row_view.findViewById(R.id.CWID);
            CWID.setText(Integer.toString(s.getCWID()));
            CWID.setPadding(10,10,10,10);

            root.addView(row_view);

        }


    }
}
