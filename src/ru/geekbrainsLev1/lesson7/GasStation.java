package ru.geekbrains.lesson7;

public class GasStation {
    private int available;

    public GasStation(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }

    public void refill(int amount) {
        this.available -= amount;
    }
public String toString () {
        return "Gasstation";

    }

}
