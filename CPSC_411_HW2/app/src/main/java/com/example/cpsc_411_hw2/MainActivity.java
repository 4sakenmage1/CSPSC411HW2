package com.example.cpsc_411_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cpsc_411_hw2.adapter.SummaryListAdapter;
import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;

    StudentDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new StudentDB(this);

        setContentView(R.layout.student_list);
        root = findViewById(R.id.student_list);

        ArrayList<Student> studentList = db.getStudentList();
        for(int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);

            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);

            ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
            ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
            root.addView(row_view);
        }
    }

}
