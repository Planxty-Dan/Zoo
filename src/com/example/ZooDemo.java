package com.example;

/**
 * Created by admin on 9/29/14.
 */
public class ZooDemo {
    public static void main(String[] args) {
        boolean menuLoop = true;
        System.out.println("Welcome to the Zoo");
        Operations myOps = new Operations();

        while (menuLoop) {
            menuLoop = myOps.menu();
        }
    }
}
