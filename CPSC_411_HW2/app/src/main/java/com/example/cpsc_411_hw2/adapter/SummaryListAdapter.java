package com.example.cpsc_411_hw2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpsc_411_hw2.R;
import com.example.cpsc_411_hw2.StudentDetailActivity;
import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

public class SummaryListAdapter extends BaseAdapter {

    @Override
    public int getCount(){return StudentDB.getInstance().getStudentList().size();}

    @Override
    public Object getItem(int i){return StudentDB.getInstance().getStudentList().get(i);}

    @Override
    public long getItemId(int i){return i;}

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View row_view;

        if (view == null) {
            // cnt++;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_rows, viewGroup, false);
        } else row_view = view;

        Student s = StudentDB.getInstance().getStudentList().get(i);

        TextView firstNameView = (TextView) row_view.findViewById(R.id.first_name);
        firstNameView.setText(s.getFirstName());
        TextView lastNameView = (TextView) row_view.findViewById(R.id.last_name);
        lastNameView.setText(s.getLastName());
        TextView cwid = (TextView) row_view.findViewById(R.id.CWID);
        cwid.setText(Integer.toString(s.getCWID()));

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }


}
