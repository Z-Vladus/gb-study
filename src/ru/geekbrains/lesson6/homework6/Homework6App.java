package ru.geekbrains.lesson6.homework6;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */
public class Homework6App {
    public static void main(String[] args) {
        Cat murzik = new Cat();
        Dog zhuchka = new Dog();
        zhuchka.run(200);
        Mommals.mommalCounter=3;
        System.out.println("Mommals counter="+Mommals.mommalCounter);
        System.out.println("Cat counter="+Cat.getCatCounter());
        System.out.println("Dog counter="+Dog.getDogCounter());

    }

}
