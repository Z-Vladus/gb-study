package ru.geekbrains.lesson6.homework6;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
   (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */
public class Homework6App {
    public static void main(String[] args) {
        Mammal[] mammals = new Mammal[20];
        for (int i = 0; i < 10; i++) {
            int j = ((int) (Math.random() * 10));
            // debug System.out.println("mammal randomizer returned " + j);
            if (j < 5) {
                mammals[i] = new Cat();
                Cat loopCat = (Cat) mammals[i];
                System.out.println("New cat! Name= " + loopCat.getCatName());
            } else {
                mammals[i] = new Dog();
                Dog loopDog = (Dog) mammals[i];
                System.out.println("New cat! Name= " + loopDog.getDogName());
            }

            System.out.print("Cats=" + Cat.getCatCounter());
            System.out.print(" Dogs=" + Dog.getDogCounter());
            System.out.println(" Mammals=" + Mammal.getMammalCounter());

            mammals[i].run(50);
            mammals[i].run(250);
            mammals[i].run(500);
            mammals[i].swim(-1);
            mammals[i].swim(5);
            mammals[i].swim(50);
        }
    }

}
