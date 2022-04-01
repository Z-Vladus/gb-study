package ru.geekbrains.lesson7;

public class Car {
    private final int volume;

    public int getVolume() {
        return volume;
    }

    public Car(int volume) {
        this.volume = volume;
    }
public void takeGas(GasStation station){
        station.refill(volume);
    }
    public void findGasoline(GasStation[] stations){
        for (GasStation station: stations) {
            if (station.getAvailable()< volume) continue;
            station.refill(volume);
            break;
        }
    }
}
