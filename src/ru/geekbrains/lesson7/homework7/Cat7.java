package ru.geekbrains.lesson7.homework7;

public final class Cat7 extends Mammal7 {
    // имя
    private String name;

    // объём желудка
    private int belly_vol=20;
    private int belly_now;

    // кол-во котов
    static int catCounter=0;

    public int getBelly_vol() {
        return belly_vol;
    }

    public void setBelly_vol(int belly_vol) {
        this.belly_vol = belly_vol;
    }

    public String getCatName() {
        return name;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public Cat7(String name) {
        this.name = name;
        addMammalCounter();

        Cat7.catCounter++;
    }

    public Cat7() {
        Cat7.catCounter++;
        addMammalCounter();
        String[] str={"Блик", "Изумруд", "Николас", "Персик", "Томас", "Ураган", "Чижик", "Шкипер"};
        this.name = str[(int)(Math.random()*8)];

    }

    public int getBelly_now() {
        return belly_now;
    }

    public void setBelly_now(int belly_now) {
        this.belly_now = belly_now;
    }
}
