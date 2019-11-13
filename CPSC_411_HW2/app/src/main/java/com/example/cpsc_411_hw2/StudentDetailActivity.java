package com.example.cpsc_411_hw2;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    protected int studentIndex;

    @Override
    protected void onCreate (Bundle savedInstance){
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


}
