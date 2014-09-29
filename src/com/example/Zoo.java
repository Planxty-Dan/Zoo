package com.example;

import java.util.ArrayList;

/**
 * Created by admin on 9/29/14.
 */
public class Zoo {
    ArrayList<Pen> allOfThePens= new ArrayList<Pen>();

    public void addPen(Pen thisPen) {
        allOfThePens.add(thisPen);
    }

    public Pen penSearch(String penName) {
        for (Pen currentPen : allOfThePens) {
            if (currentPen.getPenName().equalsIgnoreCase(penName))
                return currentPen;
        }
        System.out.println(penName + " was not found");
        return null;
    }

    public void removePen(Pen penName) {
        allOfThePens.remove(penName);
    }
}
