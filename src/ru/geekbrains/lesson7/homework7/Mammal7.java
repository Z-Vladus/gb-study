package ru.geekbrains.lesson7.homework7;

public class Mammal7 {
    static int mammalCounter = 0;



    //сытость от 0 до 100.
    int satiety;

    public static int getMammalCounter() {
        return mammalCounter;
    }

    public static void addMammalCounter() {
        Mammal7.mammalCounter++;
    }

    public boolean isHungry() {
        if (satiety < 100) return true;
        else return false;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("enter correct distance [0..10]");
            return;
        }

        if (this.getClass().getSimpleName().equals("Dog7")) {
            if (distance <= 10) {
                System.out.println("Dog swims " + distance + " meters");
            } else {
                System.out.println("Dog can not swim " + distance + " meters, it is too long");
            }
        }
        if (this.getClass().getSimpleName().equals("Cat7")) {
            System.out.println("Cats do not swim");
        }
    }
    /*
    public void run(int distance) {

        if (distance <= 0) {
            System.out.println("enter correct distance [0..500]");
            return;
        }

        if (this.getClass().getSimpleName().equals("Dog7")) {
            if (distance <= 500) {
                System.out.println("Dog runs " + distance + " meters");
            } else {
                System.out.println("Dog can not run " + distance + " meters, it is too long");
            }


        }
        if (this.getClass().getSimpleName().equals("Cat7")) {
            if (distance <= 200) {
                System.out.println("Cat runs " + distance + " meters");
            } else {
                System.out.println("Cat can not run " + distance + " meters, it is too long");
            }
        }


    } */
}

