package com.example.cpsc_411_hw2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cpsc_411_hw2.R;
import com.example.cpsc_411_hw2.models.Courses;
import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {
    private ArrayList<Courses> mCourseArrayList;

    @Override
    public int getCount() {
        return mCourseArrayList.size();
    }

    public CourseListAdapter(Student student) {
        mCourseArrayList = student.getCourses();
    }

    @Override
    public Object getItem(int i)
    {
        return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        View row_view;

        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.course_rows, viewGroup, false);

        }
        else
        {
            row_view = view;
        }

        //


        ((TextView) row_view.findViewById(R.id.course_id)).setText(mCourseArrayList.get(i).getCourseID());

        ((TextView) row_view.findViewById(R.id.course_grade)).setText(mCourseArrayList.get(i).getmGrade());


        row_view.setTag(new Integer(i));


        return row_view;
    }



}
