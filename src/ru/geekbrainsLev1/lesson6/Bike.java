package ru.geekbrains.lesson6;

public class Bike extends Transport{
    int wheelsNumber;

    public Bike(int wheelsNumber) {
        this.wheelsNumber = wheelsNumber;
    }

    @Override
    public void wroomWroom() {
        System.out.println("BZZZZZZZ");
    }
    public final boolean requireHelmet() {
        return true;
    }
}