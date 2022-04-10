package ru.geekbrains.lesson7.homework7;

public class Dog7 extends Mammal7 {
    public String getName() {
        return name;
    }

    private String name;
    static int dogCounter=0;
    // сколько в желудке сейчас
    private int belly_now;
    // объём желудка
    private int belly_vol=40;


    public int getBelly_vol() {
        return belly_vol;
    }

    public void setBelly_vol(int belly_vol) {
        this.belly_vol = belly_vol;
    }

    public int getBelly_now() {
        return belly_now;
    }

    public void setBelly_now(int belly_now) {
        this.belly_now = belly_now;
        this.satiety =(int)(((float) belly_now/belly_vol)*100);
        System.out.println("Собака "+this.name+" в желудке имеет "+belly_now+" из "+this.belly_vol+"; сытость ="+this.satiety);
    }



    public static int getDogCounter() {
        return dogCounter;
    }

    public String getDogName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog7() {
        String[] str={"Зума","Маршал","Скай","Гонщик", "Роки", "Эверест", "Крепыш"};
        int i,j;
        this.name = str[((int)(Math.random()*6))];

        dogCounter++;
        addMammalCounter();

    }


}

