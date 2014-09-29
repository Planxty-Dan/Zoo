package com.example;

/**
 * Created by admin on 9/29/14.
 */
public class Animal {
    private String name;
    private String species;
    private String gender;

    public Animal (String name, String species, String gender) {
        this.species = species;
        this.name = name;
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
