package com.example.roomcrud.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    public void studentInsertion(student s);

    @Query("Select * from Student")
    List<student> getStudent();

    @Query("Update Student set student_name = :stuName where stuId = :stuID")
    void updateStu(String stuName , int stuID);

    @Query("Delete from Student where stuId = :stuID")
    void deleteStu (int stuID);

}
