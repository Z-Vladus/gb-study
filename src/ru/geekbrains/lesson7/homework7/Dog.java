package ru.geekbrains.lesson7.homework7;

import ru.geekbrains.lesson6.homework6.Mammal;

public class Dog extends Mammal {
    private String name;
    static int dogCounter=0;

    public static int getDogCounter() {
        return dogCounter;
    }

    public String getDogName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
        String[] str={"Зума","Маршал","Скай","Гонщик", "Роки", "Эверест", "Крепыш"};
        int i,j;
        this.name = str[((int)(Math.random()*6))];
        dogCounter++;
        addMammalCounter();

    }


}

