package com.maad.notesappviewmodel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteModel.class}, version = 1)
public abstract class DBHelper extends RoomDatabase {

    private static DBHelper instance;

    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context, DBHelper.class, "MyDB")
                    .build();
        }
        return instance;
    }

    public abstract NoteDao noteDao();

}
