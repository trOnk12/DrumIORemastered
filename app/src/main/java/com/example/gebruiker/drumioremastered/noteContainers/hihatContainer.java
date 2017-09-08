package com.example.gebruiker.drumioremastered.noteContainers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Gebruiker on 5-9-2017.
 */

public class hihatContainer {

   private ArrayList<Boolean> activeNotes;

    public hihatContainer(){

        activeNotes = new ArrayList<>(4);
       // Collections.fill(activeNotes,false);
        activeNotes.add(0,false);
        activeNotes.add(1,false);
        activeNotes.add(2,false);
        activeNotes.add(3,false);

    }

    public void changeNoteState(int note){

        if(activeNotes.get(note))
        activeNotes.set(note,false);
        else
            activeNotes.set(note,true);
    }

    public boolean getNoteState(int note){
        return activeNotes.get(note);
    }

}
