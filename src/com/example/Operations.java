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

    public boolean menu() {
        System.out.println("What would you like to do?\n" +
                "1: Make a new pen\n" +
                "2: Remove a pen\n" +
                "3: Add a new animal\n" +
                "4: Remove an animal\n" +
                "5: Add a baby animal\n" +
                "6: Remove a baby animal\n" +
                "7: Put animal in pen\n" +
                "8: View animals in a pen\n" +
                "9: View all animals\n" +
                "10: Exit\n");

        menuChoice = getNumbers();
        return menuSwitch(menuChoice);
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
    public boolean menuSwitch(int menuChoice) {
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
            case 7: addAnimalToPenGetInfo();
                break;
            case 8: displayPennedAnimals();
                break;
            case 9: displayPennedAnimals();
                displayHomelessAnimals();
                break;
            case 10: return false;
        }return true;
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
            myPen.removeBabyAnimal(thisBabyAnimal);
    }

    public void addAnimalToPenGetInfo() {
        String animalName;
        Pen thisPen;
        Animal thisAnimal;
        BabyAnimal thisBabyAnimal;
        thisPen = findPen();
        animalName = findAnimal();
        thisAnimal = animalSearch(animalName);
        thisBabyAnimal = babyAnimalSearch(animalName);
        addAnimalToPen(thisAnimal, thisBabyAnimal, thisPen);
    }
    public void addAnimalToPen(Animal thisAnimal, BabyAnimal thisBabyAnimal, Pen thisPen) {
        if(thisAnimal != null)
            myZoo.putAnimalInPen(thisPen, thisAnimal);
        else if(thisBabyAnimal != null)
            myZoo.putBabyAnimalInPen(thisPen, thisBabyAnimal);
        else
            System.out.println("Could not find that animal");
    }

    public Pen findPen() {
        String scanTemp;
        Pen thisPen;
        System.out.println("Which pen do you want to add an animal to?");
        displayPens();
        scanTemp = myScan.nextLine();
        thisPen = myZoo.penSearch(scanTemp);
        return thisPen;
    }

    public String findAnimal() {
        String scanTemp;
        System.out.println("Which animal do you wan to add?");
        displayHomelessAnimals();
        scanTemp = myScan.nextLine();
        return scanTemp;
    }
    public Animal animalSearch(String animalName) {
        Animal thisAnimal;
        thisAnimal = myPen.animalSearch(animalName);
        return thisAnimal;
    }
    public BabyAnimal babyAnimalSearch(String animalName) {
        BabyAnimal thisBabyAnimal;
        thisBabyAnimal = myPen.babyAnimalSearch(animalName);
        return thisBabyAnimal;
    }

    public void displayPens() {
        for (Pen currentPen: myZoo.allOfThePens)
            System.out.println(currentPen.getPenName() + "\n");
    }

    public void displayPennedAnimals() {
        for(Pen currentPen: myZoo.allOfThePens) {
            System.out.println(currentPen.getPenName() + ": \n");
            for (Animal currentAnimal: currentPen.allOfTheAnimals)
                System.out.println(currentAnimal.getName() + "\n");
            for (BabyAnimal currentBabyAnimal: currentPen.allOfTheBabyAnimals)
                System.out.println(currentBabyAnimal.getName() + "\n");
        }
    }

    public void displayHomelessAnimals() {
        System.out.println("Homeless animals that are roaming the zoo:\n");
        for (Animal currentAnimal: myPen.allOfTheAnimals)
            System.out.println(currentAnimal.getName());
        for (BabyAnimal currentBabyAnimal: myPen.allOfTheBabyAnimals)
            System.out.println(currentBabyAnimal.getName());
    }
}

