package com.example;

import java.util.ArrayList;

/**
 * Created by admin on 9/29/14.
 */
public class Zoo {
    ArrayList<Pen> allOfThePens= new ArrayList<Pen>();
    Pen pen = new Pen("");

    public void addPen(Pen thisPen) {
        allOfThePens.add(thisPen);
    }

    public ArrayList<Pen> getAllOfThePens() {
        return allOfThePens;
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

    public void putAnimalInPen(Pen thisPen, Animal thisAnimal) {
        thisPen.addAnimal(thisAnimal);
        pen.allOfTheAnimals.remove(thisAnimal);
    }

    public void putBabyAnimalInPen(Pen thisPen, BabyAnimal thisBabyAnimal) {
        thisPen.addBabyAnimal(thisBabyAnimal);
        pen.allOfTheBabyAnimals.remove(thisBabyAnimal);
    }
}
