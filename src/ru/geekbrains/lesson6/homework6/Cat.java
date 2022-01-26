package ru.geekbrains.lesson6.homework6;

public class Cat extends Mammal {
    private String name;
    static int catCounter=0;

    public String getCatName() {
        return name;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public Cat(String name) {
        this.name = name;
        addMammalCounter();
        Cat.catCounter++;
    }

    public Cat() {
        Cat.catCounter++;
        addMammalCounter();
        String[] str={"Блик", "Изумруд", "Николас", "Персик", "Томас", "Ураган", "Чижик", "Шкипер"};
        this.name = str[(int)(Math.random()*8)];

    }
}
