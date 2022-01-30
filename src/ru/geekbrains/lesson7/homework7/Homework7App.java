package ru.geekbrains.lesson7.homework7;

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
        // массив из 10 животных проинициализируем случайно
        for (int i = 0; i < 10; i++) {
            int j = ((int) (Math.random() * 10));
            // debug System.out.println("mammal randomizer returned " + j);
            if (j < 5) {
                mammals[i] = new Cat7();
                Cat7 loopCat = (Cat7) mammals[i];
                //System.out.println("New cat! Name= " + loopCat.getCatName());
            } else {
                mammals[i] = new Dog7();
                Dog7 loopDog = (Dog7) mammals[i];
                //System.out.println("New dog! Name= " + loopDog.getDogName());
            }

        }


        System.out.print("Cats=" + Cat7.getCatCounter());
        System.out.print(" Dogs=" + Dog7.getDogCounter());
        System.out.println(" Mammals=" + Mammal7.getMammalCounter());

        //животные созданы. надо покормить. Кот съедает не более 20 единиц корма, собака - не более 40.
        //создаём миски 10 штук - 5 для котов, с объёмом 25, и 5 для собак с объёмом 50
        Bowl[] bowls = new Bowl[10];
        for (int i = 0; i < 10; i++) {
            //bowls[i] = new Bowl(25); //25
            if (i % 2 == 0) bowls[i] = new Bowl(10);
            else bowls[i] = new Bowl(20);
            //заполняем миску до полного
            bowls[i].setAmount(bowls[i].vol);
            //и выводим графически заполнение
            //System.out.print("bowl["+i+"] fullness: ");bowls[i].getGrAmount();System.out.println();

        }

        // но проблема в том, что животные не знают где чьи миски и кушают по одному до сыта.
        for (int i = 0; i < mammals.length; i++) {
            System.out.println("***************************");
            System.out.println("Животное №" + i + " пришло кушать");
            if (mammals[i].isHungry()) eatFromRandomBowl(mammals[i], bowls);
            System.out.println("Животное №" + i + " покушало(или попыталось =) )");
            for (int j = 0; j < bowls.length; j++) {
                System.out.print("Bowl " + j + ":");
                bowls[j].getGrAmount();
                System.out.println();
            }
        }
        System.out.println("************************************************");
        System.out.println("Итоги после еды:");
        for (int i = 0; i < mammals.length; i++) {
            System.out.println("Животное №" + i + " сыто на " + mammals[i].satiety + "%");
        }
        System.out.println("Чашки:");
        for (int j = 0; j < bowls.length; j++) {
            System.out.print("Bowl " + j + ":");
            bowls[j].getGrAmount();
            System.out.println();
        }

        // теперь пусть коты побегают и проголодаются. много бегают = больше съедят.

        for (int i = 0; i < mammals.length; i++) {
            if (mammals[i].getClass().getSimpleName().equals("Cat7")) {
                Cat7 loopCat = (Cat7) mammals[i];
                loopCat.catRun((int)(Math.random()*150));


            }
        }

    }


    private static void eatFromRandomBowl(Mammal7 mammal, Bowl[] bowls) {
        boolean isCat = false, isDog = false; // по-умолчанию у нас животное которое есть - кот


        // сколько сможет съесть животное?
        int bellyFreeVol = 0;
        if (mammal.getClass() == Cat7.class) {
            bellyFreeVol = ((Cat7) mammal).getBelly_vol() - ((Cat7) mammal).getBelly_now();
            System.out.println("Этот кот может съесть " + bellyFreeVol + " еды");
            isCat = true;
            isDog = false;
        }

        if (mammal.getClass() == Dog7.class) {
            bellyFreeVol = ((Dog7) mammal).getBelly_vol() - ((Dog7) mammal).getBelly_now();
            System.out.println("Эта собака может съесть " + bellyFreeVol + " еды");
            isCat = false;
            isDog = true;
        }

        // кушаем из случайной миски с едой. Если там пусто, то животное будет искать 9 раз в соседних мисках.
        // животное идёт от этой миски вправо, и если не находит еду вплоть до 10-й миски, то идёт обратно.
        int tryCount = 0;
        int i = (int) (Math.random() * 10);

        do {
            System.out.print("Животное идёт к миске №" + i);
            System.out.print(" ; здесь еды " + bowls[i].getAmount() + " ");
            bowls[i].getGrAmount();
            System.out.println();
            if (bowls[i].getAmount() == 0) {
                System.out.println("Чашка пуста, идём далее вправо");
                if (i < 10) {
                    i++;
                    continue;
                } else {
                    System.out.println("дошли до 10-й миски!");
                    break;
                }
            }

            // животное у миски с едой. у нас есть 2 случая.
            // 1 - животное съест всю еду и пойдёт к след. миске не несытившись
            if (bowls[i].getAmount() < bellyFreeVol) {
                if (isCat) {
                    ((Cat7) mammal).setBelly_now(((Cat7) mammal).getBelly_now() + bowls[i].getAmount());
                    bowls[i].setAmount(0);
                    System.out.println("Кот съел всё в этой миске,но не наелся!");
                    bellyFreeVol = ((Cat7) mammal).getBelly_vol() - ((Cat7) mammal).getBelly_now();
                    System.out.println("Этот кот может съесть ещё " + bellyFreeVol + " еды");

                }
                if (isDog) {
                    ((Dog7) mammal).setBelly_now(((Dog7) mammal).getBelly_now() + bowls[i].getAmount());
                    bowls[i].setAmount(0);
                    System.out.println("Собака съела всё в этой миске,но не наелась!");
                    bellyFreeVol = ((Dog7) mammal).getBelly_vol() - ((Dog7) mammal).getBelly_now();
                    System.out.println("Эта собака может съесть ещё " + bellyFreeVol + " еды");

                }
            }
            // 2 - животное частично или полностью съест еду и насытится
            if (bowls[i].getAmount() >= bellyFreeVol) {
                if (isCat) {
                    //из чашки забираем столько, насколько голоеден зверь
                    bowls[i].setAmount(bowls[i].getAmount() - bellyFreeVol);
                    //еды много, заполняем желудок полностью
                    ((Cat7) mammal).setBelly_now(((Cat7) mammal).getBelly_vol());
                    System.out.println("Кот поел, теперь сыт");
                    break;
                }
                if (isDog) {
                    bowls[i].setAmount(bowls[i].getAmount() -
                            ((Dog7) mammal).getBelly_now());
                    ((Dog7) mammal).setBelly_now(((Dog7) mammal).getBelly_vol());

                    System.out.println("Собака поела, теперь сыта");
                    break;
                }

            }
            System.out.println("Животное сыто на " + mammal.satiety + "%");
            i++;
        } while (i < 10 && mammal.isHungry());

        // если всё ещё голодно и в 10-й миске пусто, идём назад, справа налево, от 9-й миски.

        if (mammal.isHungry()) {
            System.out.println("попробуем поискать еду в мисках, которые слева");
            for (i = 8; (i >= 0); i--) {
                System.out.print("Животное идёт к миске №" + i);
                System.out.print(" ; здесь еды " + bowls[i].getAmount() + " ");
                bowls[i].getGrAmount();
                System.out.println();
                if (bowls[i].getAmount() == 0) {
                    System.out.println(" Чашка пуста, идём назад!");
                    continue;
                }
                // животное у миски. у нас есть 2 случая.
                // 1 - животное съест всю еду и пойдёт к след. миске  не несытившись
                if (bowls[i].getAmount() < bellyFreeVol) {
                    if (isCat) {
                        ((Cat7) mammal).setBelly_now(((Cat7) mammal).getBelly_now() + bowls[i].getAmount());
                        bowls[i].setAmount(0);
                        System.out.println("Кот поел и здесь, но всё ещё голоден");
                        bellyFreeVol = ((Cat7) mammal).getBelly_vol() - ((Cat7) mammal).getBelly_now();
                        System.out.println("Этот кот может съесть ещё " + bellyFreeVol + " еды");
                    }
                    if (isDog) {
                        ((Dog7) mammal).setBelly_now(((Dog7) mammal).getBelly_now() + bowls[i].getAmount());
                        bowls[i].setAmount(0);
                        System.out.println("Собака поела здесь, но ещё голодна");
                        bellyFreeVol = ((Dog7) mammal).getBelly_vol() - ((Dog7) mammal).getBelly_now();
                        System.out.println("Эта собака может съесть ещё " + bellyFreeVol + " еды");
                    }
                }
                // 2 - животное частично или полностью съест еду и насытится
                if (bowls[i].getAmount() >= bellyFreeVol) {
                    if (isCat) {
                        ((Cat7) mammal).setBelly_now(((Cat7) mammal).getBelly_vol());
                        bowls[i].setAmount(bowls[i].getAmount() - bellyFreeVol);
                        System.out.println("Кот поел, теперь должен быть сыт");
                        break;
                    }
                    if (isDog) {
                        ((Dog7) mammal).setBelly_now(((Dog7) mammal).getBelly_vol());
                        bowls[i].setAmount(bowls[i].getAmount() - bellyFreeVol);
                        System.out.println("Собака поела, теперь должна быть сыта");
                        break;
                    }

                }
                System.out.println("Животное сыто на " + mammal.satiety + "%");
                if ((i == 0) && mammal.isHungry()) {
                    System.out.println("->>>>> Всем миски пусты, а животное ещё голодно!<<<<<-");
                }
            }
            if (mammal.isHungry()) {
                System.out.println("->>>>> Всем миски пусты и осмотрены, а животное ещё голодно!<<<<<-");
            }

        }
    }

}
