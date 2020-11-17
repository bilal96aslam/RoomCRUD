package com.example.roomcrud.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =  {student.class} , version = 1 )
public abstract class database extends RoomDatabase {

    public abstract DAO dao();
}
