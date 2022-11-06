package com.example.jitcampusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class departmentS1Activity extends AppCompatActivity {

    Button buttonCse;
    Button buttonMech;
    Button buttonCivil;
    Button buttonEEE;
    Button buttonECE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_s1);

        buttonCse = findViewById(R.id.cse_s6);
        buttonMech = findViewById(R.id.mech_s6);
        buttonCivil = findViewById(R.id.civil_s6);
        buttonEEE = findViewById(R.id.eee_s6);
        buttonECE = findViewById(R.id.ece_s6);

        //CSE
        buttonCse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Semester_1_cse_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        //MECH
        buttonMech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Semester_1_mech_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        //CIVIL
        buttonCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Semester_1_civil_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        //EEE
        buttonEEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Semester_1_eee_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        //ECE
        buttonECE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Semester_1_ece_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

    }
}