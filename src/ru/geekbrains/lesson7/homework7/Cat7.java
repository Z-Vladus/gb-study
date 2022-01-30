package ru.geekbrains.lesson7.homework7;

public final class Cat7 extends Mammal7 {
    public String getName() {
        return name;
    }

    // имя
    private String name;

    // объём желудка и сколько еды там сейчас
    private int belly_vol=20;
    private int belly_now;
    public final int catRunDst = 200;

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
        this.satiety =(int)(((float) belly_now/belly_vol)*100);
        System.out.println("Кот "+this.name+" в желудке имеет "+belly_now+" из "+this.belly_vol+"; сытость ="+this.satiety);

    }

    public void catRun(int d) {
        System.out.println("Получено задание пробежать "+d+"метров");

        int canRun= (int) (catRunDst* (float)belly_now/belly_vol);
        if (this.belly_vol==this.belly_now) {
            canRun=catRunDst;}

        System.out.println("Кот "+this.name+" может пробежать "+canRun+" метров ; сытость = "+this.satiety);
        if ((d <= catRunDst)&&(canRun>0)) {
            System.out.print("Кот пробежал " + d + " метров, устал.");
            setBelly_now(20 - (int)( ((float)d/catRunDst)*20));
            canRun= (int) (catRunDst* (float)belly_now/belly_vol);
            if (canRun==0) {
                System.out.println("Кот больше бежать не может ");
            } else {
                System.out.println("может пробежать ещё " + canRun + " метров");
            }
        } else {
            System.out.println("Кот не может пробежать " + d + " метров, он устал или дистания слишком большая");
        }

    }
}
