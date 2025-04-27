package com.example.studentsdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {


    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table studentData(rollno varchar(5),name varchar(20),gender varchar(20),speciality varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists studentData");
        onCreate(db);
    }

    public long addStudents(String roll, String name, String gender, String speciality) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("rollno",roll);
        values.put("name",name);
        values.put("gender",gender);
        values.put("speciality",speciality);
        long k=db.insert("studentData",null,values);
        return k;
    }

    public String getStudents() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from studentData",null);
        String output="";
        while (cursor.moveToNext()) {
            String no=cursor.getString(0);
            String naam=cursor.getString(1);
            String gen=cursor.getString(2);
            String special=cursor.getString(3);
            output=output+no+"      "+naam+"      "+gen+"      "+special+"\n\n";
        }
        return output;
    }
}
