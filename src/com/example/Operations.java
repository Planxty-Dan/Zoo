package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by admin on 9/29/14.
 */
public class Operations {
    int menuChoice = 0;
    Scanner myScan = new Scanner(System.in);
    Zoo myZoo = new Zoo();
    Pen myPen = new Pen("");

    public void menu() {
        System.out.println("What would oyu like to do?\n" +
                "1: Make a new pen" +
                "2: Remove a pen" +
                "3: Add a new animal" +
                "4: Remove an animal" +
                "5: Add a baby animal" +
                "6: Remove a baby animal" +
                "7: Put animal in pen" +
                "8: View animals in a pen" +
                "9: View all animals" +
                "10: Exit");

        menuChoice = getNumbers();
        menuSwitch(menuChoice);

    }
    public int getNumbers() {
        Scanner getNumScan = new Scanner(System.in);
        for (; ; )
            try {
                int getNum = getNumScan.nextInt();
                return getNum;
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number entry.\n" +
                        "Please enter a valid number.");
                getNumScan.nextLine();
            }
    }
    public void menuSwitch(int menuChoice) {
        switch (menuChoice) {
            case 1: makePen();
                break;
            case 2: removePen();
                break;
            case 3: addAnimal();
                break;
            case 4: removeAnimal();
                break;
            case 5: addBabyAnimal();
                break;
            case 6: removeBabyAnimal();
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
    }
    public void makePen() {
        String penName;
        System.out.println("What do you want to name the pen?");
        penName = myScan.nextLine();
        Pen thisPen = new Pen(penName);
        myZoo.addPen(thisPen);
        System.out.println(penName + " has been added.\n");
        menu();
    }
    public void removePen() {
        String penName;
        Pen thisPen;
        System.out.println("What is the name of the pen you want to delete?");
        penName = myScan.nextLine();
        thisPen = myZoo.penSearch(penName);
        if (thisPen != null)
            myZoo.removePen(thisPen);
    }
    public void addAnimal() {
        String animalSpecies;
        String animalName;
        String animalGender;
        System.out.println("What is the species of the animal you want to add?");
        animalSpecies = myScan.nextLine();
        animalGender = genderAssignment();
        System.out.println("what is the animals name?");
        animalName = myScan.nextLine();
        Animal thisAnimal = new Animal(animalName, animalSpecies, animalGender);
        myPen.addAnimal(thisAnimal);

    }

    public String genderAssignment() {
        String animalGender;
        System.out.println("Is the animal male or female? (enter m/f)");
        animalGender = myScan.nextLine();
        if (animalGender.equalsIgnoreCase("m"))
            animalGender = "male";
        else if (animalGender.equalsIgnoreCase("f"))
            animalGender = "female";
        else {
            System.out.println(animalGender + "is not a valid selection.");
            genderAssignment();
        }
        return animalGender;
    }

    public void removeAnimal() {
        String animalName;
        Animal thisAnimal;
        System.out.println("What is the name of the animal you want to remove?");
        animalName = myScan.nextLine();
        thisAnimal = myPen.animalSearch(animalName);
        if (thisAnimal != null)
            myPen.removeAnimal(thisAnimal);
    }

    public void addBabyAnimal() {
        String babyAnimalSpecies;
        String babyAnimalName;
        String babyAnimalGender;
        int babyAnimalCuteness;
        System.out.println("What is the species of the animal you want to add?");
        babyAnimalSpecies = myScan.nextLine();
        babyAnimalGender = genderAssignment();
        System.out.println("what is the animals name?");
        babyAnimalName = myScan.nextLine();
        System.out.println("On a scale of 1 to 10, how cute is this baby animal?");
        babyAnimalCuteness = getNumbers();
        BabyAnimal thisBabyAnimal = new BabyAnimal(babyAnimalCuteness, babyAnimalSpecies, babyAnimalName, babyAnimalGender);
        myPen.addBabyAnimal(thisBabyAnimal);
    }

    public void removeBabyAnimal() {
        String babyAnimalName;
        BabyAnimal thisBabyAnimal;
        System.out.println("What is the name of the baby animal you want to remove?");
        babyAnimalName = myScan.nextLine();
        thisBabyAnimal = myPen.babyAnimalSearch(babyAnimalName);
        if (thisBabyAnimal != null)
            myPen.removeAnimal(thisBabyAnimal);
    }
}

