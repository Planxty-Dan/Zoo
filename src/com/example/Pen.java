package com.example;

import java.util.ArrayList;

/**
 * Created by admin on 9/29/14.
 */
public class Pen {
    ArrayList<Animal> allOfTheAnimals = new ArrayList<Animal>();
    ArrayList<BabyAnimal> allOfTheBabyAnimals = new ArrayList<BabyAnimal>();

    String penName;
    Animal eachAnimal;
    BabyAnimal eachBabyAnimal;

    public void addAnimal(Animal thisAnimal) {
        allOfTheAnimals.add(thisAnimal);
        System.out.println(thisAnimal + " has been added.");
    }

    public Animal animalSearch(String animalName) {
        for (Animal currentAnimal : allOfTheAnimals) {
            if (currentAnimal.getName().equalsIgnoreCase(animalName))
                return currentAnimal;
        }
        System.out.println(animalName + " was not found");
        return null;
    }

    public void removeAnimal(Animal thisAnimal) {
        allOfTheAnimals.remove(thisAnimal);
    }

    public void addBabyAnimal(BabyAnimal thisBabyAnimal) {
        allOfTheBabyAnimals.add(thisBabyAnimal);
        System.out.println(thisBabyAnimal + " has been added.");
    }

    public BabyAnimal babyAnimalSearch(String babyAnimalName) {
        for (BabyAnimal currentBabyAnimal : allOfTheBabyAnimals) {
            if (currentBabyAnimal.getName().equalsIgnoreCase(babyAnimalName))
                return currentBabyAnimal;
        }
        System.out.println(babyAnimalName + " was not found");
        return null;
    }

    public void removeBabyAnimal(BabyAnimal thisBabyAnimal) {
        allOfTheBabyAnimals.remove(thisBabyAnimal);
    }

    public Pen(String penName) {
        this.penName = penName;
    }

    public String getPenName() {
        return penName;
    }
}
