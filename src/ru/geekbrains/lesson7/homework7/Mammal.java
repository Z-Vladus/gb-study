package ru.geekbrains.lesson7.homework7;

public class Mammal {
    static int mommalCounter=0;

    public static int getMammalCounter() {
        return mommalCounter;
    }

    public static void addMammalCounter() {
        Mammal.mommalCounter++;
    }

    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("enter correct distance [0..10]");
            return;
        }

        if (this.getClass().getSimpleName().equals("Dog")) {
            if (distance <= 10) {
                System.out.println("Dog swims " + distance + " meters");
            } else {
                System.out.println("Dog can not swim " + distance + " meters, it is too long");
            }
        }
        if (this.getClass().getSimpleName().equals("Cat")) {
            System.out.println("Cats do not swim");
        }
    }

    public void run(int distance) {

        if (distance <= 0) {
            System.out.println("enter correct distance [0..500]");
            return;
        }

        if (this.getClass().getSimpleName().equals("Dog")) {
            if (distance <= 500) {
                System.out.println("Dog runs " + distance + " meters");
            } else {
                System.out.println("Dog can not run " + distance + " meters, it is too long");
            }
        }
        if (this.getClass().getSimpleName().equals("Cat")) {
            if (distance <= 200) {
                System.out.println("Cat runs " + distance + " meters");
            } else {
                System.out.println("Cat can not run " + distance + " meters, it is too long");
            }
        }


    }
}

