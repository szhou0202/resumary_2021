package com.example.octosloths;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// BASED ON TUTORIAL: https://www.youtube.com/playlist?list=PLrnPJCHvNZuDihTpkRs6SpZhqgBqPU118

@Dao // tells room that this is a dao interface
public interface NoteDao { // backend

    @Insert // room will fill in all necessary code for the corresponding annotation
    void insert(Note note);


    // will use similiar functions for octosloth app: insert, update, and delete
    // will be very useful
    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table") // defining database operations ourselves with @query
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY endDate DESC") // is this where I should put the converter class?
    LiveData<List<Note>> getAllNotes(); // live data, will update by itself

    // for getting basic notes
    @Query("SELECT * FROM note_table WHERE entryType = 'BASIC'")
    LiveData<List<Note>> getAllBasicNotes();

    // similar methods for the rest
    @Query("SELECT * FROM note_table WHERE entryType = 'VOLUNTEERING'")
    LiveData<List<Note>> getAllVolunteeringNotes();

    @Query("SELECT * FROM note_table WHERE entryType = 'EDUCATION'")
    LiveData<List<Note>> getAllEducationNotes();

    @Query("SELECT * FROM note_table WHERE entryType = 'EXTRACURRICULAR'")
    LiveData<List<Note>> getAllExtracurricularNotes();

    @Query("SELECT * FROM note_table WHERE entryType = 'AWARD'")
    LiveData<List<Note>> getAllAwardNotes();
}
