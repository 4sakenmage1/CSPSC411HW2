package com.example.cpsc_411_hw2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cpsc_411_hw2.models.Student;
import com.example.cpsc_411_hw2.models.StudentDB;

public class AddStudentActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndex;
    protected final String TAG = "Add Student Screen";

    @Override
    protected void onCreate(Bundle savedInstance){
        Log.d(TAG, "OnCreate() Called");
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_student_details);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);
       EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
        EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
        EditText CWIDView = (EditText) findViewById(R.id.cwid_val_id);
        fNameView.setEnabled(true);
        lNameView.setEnabled(true);
        CWIDView.setEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_student_edit) {
            EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
            EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
            EditText CWIDView = (EditText) findViewById(R.id.cwid_val_id);
            fNameView.setEnabled(true);
            lNameView.setEnabled(true);
            CWIDView.setEnabled(true);
//            detailMenu.findItem(R.id.action_student_edit).setVisible(false);
            detailMenu.findItem(R.id.action_student_done).setVisible(true);
            detailMenu.findItem(R.id.action_add_student).setVisible(false);
//            Log.d(TAG, "Unintended \"edit\" button clicked on menu");
        } else if (item.getItemId() == R.id.action_student_done) {
            EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
            EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
            EditText CWIDView = (EditText) findViewById(R.id.cwid_val_id);

            Student studentObj = new Student(fNameView.getText().toString(),lNameView.getText().toString(),
                   CWIDView.getText().toString());

            StudentDB.getInstance().getStudentList().add(studentObj);

            fNameView.setEnabled(false);
            lNameView.setEnabled(false);
            CWIDView.setEnabled(false);
//            detailMenu.findItem(R.id.action_student_edit).setVisible(true);
            detailMenu.findItem(R.id.action_student_done).setVisible(false);
            detailMenu.findItem(R.id.action_add_student).setVisible(false);
        }else if (item.getItemId() == R.id.action_add_student) {
            Log.d(TAG, "Unintended \"Add Student\" button clicked on menu");
        }


        return super.onOptionsItemSelected(item);
    }





}
