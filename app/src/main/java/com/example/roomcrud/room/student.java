package com.example.roomcrud.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Student")//for showing that this class is entity

public class student {

    @PrimaryKey(autoGenerate = true)
    int stuId;

    @ColumnInfo(name="student_name") //this will be column name
    String stuFirstName;

    String stuLastName;
    String stuClass;

    public student(String stuFirstName, String stuLastName, String stuClass) {
        this.stuFirstName = stuFirstName;
        this.stuLastName = stuLastName;
        this.stuClass = stuClass;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuFirstName() {
        return stuFirstName;
    }

    public void setStuFirstName(String stuFirstName) {
        this.stuFirstName = stuFirstName;
    }

    public String getStuLastName() {
        return stuLastName;
    }

    public void setStuLastName(String stuLastName) {
        this.stuLastName = stuLastName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }
}
