package com.example.cpsc_411_hw2;

import android.os.Bundle;
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

public class StudentDetailActivity extends AppCompatActivity {

    protected int studentIndex;
    protected Menu detailsMenu;
    protected Student sObj;
    ListView mSummaryView;
    protected CourseListAdapter ad;
    Courses cObj;

    @Override
    protected void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.activity_student_details);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);
        sObj = StudentDB.getInstance().getStudentList().get(studentIndex);

        EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
        fNameView.setText(sObj.getFirstName());

        EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
        lNameView.setText(sObj.getLastName());

        EditText CWIDView = (EditText) findViewById(R.id.cwid_val_id);
        CWIDView.setText(sObj.getCWID());

        fNameView.setEnabled(true);
        lNameView.setEnabled(true);
        CWIDView.setEnabled(true);

        mSummaryView = findViewById(R.id.course_list_id);
        ad = new CourseListAdapter(sObj);
        mSummaryView.setAdapter(ad);

        Button add = (Button) findViewById(R.id.course_add_button);
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText courseIDedit = (EditText) findViewById(R.id.course_id_edit);
                EditText courseGradeedit = (EditText) findViewById(R.id.course_grade_edit);

                cObj = new Courses(courseIDedit.getText().toString(),courseGradeedit.getText().toString());
                sObj.addCourses(cObj);

                ad.notifyDataSetChanged();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detail_student_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(false);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailsMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.first_name_val_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.last_name_val_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.cwid_val_id);
            editView.setEnabled(true);
            //
            item.setVisible(false);
            detailsMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {

            EditText editView = findViewById(R.id.first_name_val_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setFirstName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.last_name_val_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setLastName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.cwid_val_id);

            StudentDB.getInstance().getStudentList().get(studentIndex).setCWID(editView.getText().toString());
            editView.setEnabled(false);

            item.setVisible(false);
            detailsMenu.findItem(R.id.action_edit).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
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
