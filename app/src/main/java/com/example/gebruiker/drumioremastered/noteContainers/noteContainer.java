package com.example.gebruiker.drumioremastered.noteContainers;

import java.util.Timer;

/**
 * Created by Gebruiker on 6-9-2017.
 */

public class noteContainer {



    private hihatContainer hihatContainer;
    private snareContainer snareContainer;

    public noteContainer(){


        hihatContainer = new hihatContainer();
        snareContainer= new snareContainer();
    }


    public hihatContainer getHihatContainer(){
        return hihatContainer;
    }

    public snareContainer getSnareContainer(){
        return snareContainer;
    }
}
