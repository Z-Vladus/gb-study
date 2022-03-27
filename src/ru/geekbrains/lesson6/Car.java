package ru.geekbrains.lesson6;

public class Car extends Transport {
    String model;
    int year;

    public Car(String model, int year) {
        System.out.println("This is a Car constructor");
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void wroomWroom() {
        System.out.println("BBBBRRRRR");
    }
}
