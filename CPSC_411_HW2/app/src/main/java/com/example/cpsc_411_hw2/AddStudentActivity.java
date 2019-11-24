package com.example.cpsc_411_hw2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cpsc_411_hw2.adapter.CourseListAdapter;
import com.example.cpsc_411_hw2.models.Courses;
import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    protected Menu detailMenu;
    ListView mSummaryView;
    protected CourseListAdapter ad;
    protected Student sObj;
    Courses cObj;
    //protected final String TAG = "Add Student Screen";

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_student_details);

        Student s = new Student("","","");
        ArrayList<Courses> courses = new ArrayList<>();
        s.setCourses(courses);

        StudentDB.getInstance().addToStudentList(s);
        sObj = StudentDB.getInstance().getStudentList().get(StudentDB.getInstance().getStudentList().size() - 1);

        mSummaryView = findViewById(R.id.course_list_id);
        ad = new CourseListAdapter(s);
        mSummaryView.setAdapter(ad);

        Button add = (Button) findViewById(R.id.course_add_button);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText cIDEdit = (EditText) findViewById(R.id.course_id_edit);
                EditText cGradeEdit = (EditText) findViewById(R.id.course_grade_edit);

                cObj = new Courses(cIDEdit.getText().toString(),cGradeEdit.getText().toString());
                sObj.addCourses(cObj);

                ad.notifyDataSetChanged();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_done) {
            EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
            sObj.setFirstName(fNameView.getText().toString());
            EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
            sObj.setLastName(fNameView.getText().toString());
            EditText CWIDView = (EditText) findViewById(R.id.cwid_val_id);
            sObj.setCWID(fNameView.getText().toString());

            fNameView.setEnabled(false);
            lNameView.setEnabled(false);
            CWIDView.setEnabled(false);


        } else {
            Intent i = new Intent(this, SummaryLV.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detail_student_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(false);
        menu.findItem(R.id.action_edit).setVisible(false);
        menu.findItem(R.id.action_done).setVisible(true);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
