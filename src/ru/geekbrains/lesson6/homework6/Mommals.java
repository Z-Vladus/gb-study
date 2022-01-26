package ru.geekbrains.lesson6.homework6;

public class Mommals {
    static int mommalCounter=0;

    public void run(int distance) {

        if (distance <= 0) {
            System.out.println("enter correct distance [0..500]");
            return;
        }

        if (this.getClass().getSimpleName().equals("Dog")) {
            if (distance < 500) {
                System.out.println("Dog runs " + distance + " meters");
            } else {
                System.out.println("Dog can not run " + distance + " meters, it is too long");
            }
        }
        if (this.getClass().getSimpleName().equals("Cat")) {
            if (distance < 200) {
                System.out.println("Cat runs " + distance + " meters");
            } else {
                System.out.println("Cat can not run " + distance + " meters, it is too long");
            }
        }


    }
}

