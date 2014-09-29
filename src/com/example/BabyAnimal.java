package com.example;

/**
 * Created by admin on 9/29/14.
 */
public class BabyAnimal extends Animal {
    int cutenessFactor;

    public BabyAnimal(int cutenessFactor, String species, String name, String gender) {
        super(species, name, gender);
        this.cutenessFactor = cutenessFactor;
    }

}
