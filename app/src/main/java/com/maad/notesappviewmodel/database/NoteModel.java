package com.maad.notesappviewmodel.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.maad.notesappviewmodel.utils.Constants;

@Entity(tableName = Constants.TABLE_NAME)
public class NoteModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.ID)
    private int id;
    private String title;
    private String description;

    public NoteModel(String title, String description){
        this.title = title;
        this.description = description;
    }

    @Ignore
    public NoteModel(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
