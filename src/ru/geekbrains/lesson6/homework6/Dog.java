package ru.geekbrains.lesson6.homework6;

public class Dog extends Mommals{
    private String name;

    public static int getDogCounter() {
        return dogCounter;
    }

    static int dogCounter=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

