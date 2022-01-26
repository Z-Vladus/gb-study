package ru.geekbrains.lesson7.homework7;

import ru.geekbrains.lesson6.homework6.Cat;
import ru.geekbrains.lesson6.homework6.Dog;
import ru.geekbrains.lesson6.homework6.Mammal;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
   (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.

1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */



public class Homework7App {
    public static void main(String[] args) {
        Mammal7[] mammals = new Mammal7[10];

        for (int i = 0; i < 10; i++) {
            int j = ((int) (Math.random() * 10));
            // debug System.out.println("mammal randomizer returned " + j);
            if (j < 5) {
                mammals[i] = new Cat7();
                Cat7 loopCat = (Cat7)mammals[i];
                System.out.println("New cat! Name= " + loopCat.getCatName());
            } else {
                mammals[i] = new Dog7();
                Dog7 loopDog = (Dog7) mammals[i];
                System.out.println("New cat! Name= " + loopDog.getDogName());
            }

        }


        System.out.print("Cats=" + Cat7.getCatCounter());
        System.out.print(" Dogs=" + Dog7.getDogCounter());
        System.out.println(" Mammals=" + Mammal.getMammalCounter());

        //животные созданы. надо покормить. Кот съедает не более 20 единиц корма, собака - не более 40.
        //создаём миски 10 штук - для котов, с объёмом 25, и для собак с объёмом 50
        Bowl[] bowls = new Bowl[10];
        for (int i = 0; i < 10; i++) {
            if (i%2==0) bowls[i].vol=25; else bowls[i].vol=50;
            //заполняяем миску до полного
            bowls[i].setAmount(bowls[i].vol);
        }
        // но проблема в том, что животные не знают где чьи миски и кушают по одному до сыта.
        for (int i = 0; i < 10; i++) {
            eatFromRandomBowl(mammals[i],bowls);

        }


        // теперь пусть побегают и проголодаются. много бегают = больше съедят.

        /*mammals[i].run(50);
        mammals[i].run(250);
        mammals[i].run(500);
        mammals[i].swim(-1);
        mammals[i].swim(5);
        mammals[i].swim(50);
*/
    }

    private static void eatFromRandomBowl(Mammal7 mammal, Bowl[] bowls) {
        // сколько сможет съесть животное?
        int bellyFreeVol;
        if (mammal.getClass()==Cat7.class) {
            bellyFreeVol = ((Cat7) mammal).getBelly_vol()-((Cat7) mammal).getBelly_now();
        }

        // кушаем из случайной миски с едой. Если там пусто, то животное будет искать 9 раз в соседних мисках.
        int tryCount=0;
        int b=(int)(Math.random()*10);
        int i=b;

        do {

            System.out.println(mammal.getClass()+" goes to bowl #"+i);
            if (bowls[i].getAmount()==0) {
                continue;
            } else {

            }


            tryCount++;
        } while ((tryCount<10)&&(mammal.isHungry()));

        if (tryCount==9) System.out.println("все миски пусты!");


    }

}
