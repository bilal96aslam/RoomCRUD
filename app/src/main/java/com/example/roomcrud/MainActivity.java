package com.example.roomcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomcrud.room.database;
import com.example.roomcrud.room.student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText firstName , secondName, className , updatename , updateid , deleteID;
    Button insert , read , btnUpdate , btnDelete;
    database myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        secondName = (EditText) findViewById(R.id.secondName);
        className = (EditText) findViewById(R.id.className);
        updatename = (EditText) findViewById(R.id.updatename);
        updateid = (EditText) findViewById(R.id.updateid);
        deleteID = (EditText) findViewById(R.id.deleteID);
        insert = (Button) findViewById(R.id.insert);
        read = (Button) findViewById(R.id.read);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        setUpDB();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                student st = new student(firstName.getText().toString() , secondName.getText().toString()
                        ,className.getText().toString());



                myDatabase.dao().studentInsertion(st);

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<student> stuData =  myDatabase.dao().getStudent();

                for (int i =0; i<stuData.size(); i++){

                    Log.d("STUDENT_DATA" , String.valueOf(stuData.get(i).getStuId() +": "+
                            stuData.get(i).getStuFirstName()+": "+ stuData.get(i).getStuLastName()+": "+
                            stuData.get(i).getStuClass()));

                }


            }
        });



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDatabase.dao().updateStu(updatename.getText().toString() , Integer.parseInt(updateid.getText().toString()));
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDatabase.dao().deleteStu(Integer.parseInt(deleteID.getText().toString()));
            }
        });



    }

    private void setUpDB(){


        myDatabase = Room.databaseBuilder(MainActivity.this , database.class , "StudentDB.db")
                .allowMainThreadQueries().build();//bcz DAO humye main UI pa data access nai karnye dita background pa krnaa hota ha
        // icc leye hum allowMethod use kar rahye hain
    }
}
