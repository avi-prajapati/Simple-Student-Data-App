package com.example.studentsdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView_fetch;

    DbHandler handler2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView_fetch=findViewById(R.id.textView_fetch);

        handler2=new DbHandler(this,"studentdb",null,1);
        String data=handler2.getStudents();

        textView_fetch.setText(data);
    }
}