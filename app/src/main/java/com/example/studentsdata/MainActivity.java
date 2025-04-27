package com.example.studentsdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText rollno,name,gender,speciality;
    Button save_button,button;
    DbHandler handler;

    private String[] array={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rollno=findViewById(R.id.rollno);
        name=findViewById(R.id.name);
        gender=findViewById(R.id.gender);
        speciality=findViewById(R.id.speciality);
        save_button=findViewById(R.id.save_button);
        button=findViewById(R.id.button);

        handler=new DbHandler(this,"studentdb",null,1);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userRollNo=rollno.getText().toString();
                String userName=name.getText().toString();
                String userGender=gender.getText().toString();
                String userSpeciality=speciality.getText().toString();

                if (true) {
                    for (String Rollno:array) {
                        if(Rollno.equals(userRollNo)) {
                            long recordId=handler.addStudents(userRollNo,userName,userGender,userSpeciality);
                            if (recordId>0) {
                                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Some error occured.", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter Valid Rollno", Toast.LENGTH_SHORT).show();
                }

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}