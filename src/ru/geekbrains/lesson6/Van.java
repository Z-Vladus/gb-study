package ru.geekbrains.lesson6;

public class Van extends Car {
    String model;
    int year;
    int seats;

    public Van(String model, int year, int seats) {
        this.model = model;
        this.year = year;
        this.seats = seats;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
