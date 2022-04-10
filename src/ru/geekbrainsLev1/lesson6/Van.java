package ru.geekbrains.lesson6;

public class Van extends Car {
    int seats;

    public Van(String model, int year, int seats) {

        super(model, year);
        System.out.println("This is a Van constructor");
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
