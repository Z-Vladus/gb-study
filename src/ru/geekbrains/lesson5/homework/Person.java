package ru.geekbrains.lesson5.homework;

import java.util.Random;

public class Person {
    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public String name;
    public String post;
    public String email;
    public String phoneNum;
    public int salary;
    public int age;


    //2. Конструктор класса должен заполнять эти поля при создании объекта
    public Person() {
        String[] namelist = {"Ярослава Москвина",
                "Малика Фадеева",
                "Даниил Куликов",
                "Лев Виноградов",
                "Александр Минаев",
                "Серафима Панкова",
                "Эмир Никифоров",
                "Никита Петровский",
                "Амина Белова",
                "Павел Волков",
                "Алексей Васильев",
                "Максим Дегтярев",
                "София Куликова",
                "Даниил Бабушкин"};
        String[] postlist = {"Бухгалтер", "Охранник", "Продавец", "Водитель", "Кассир", "Механик"};

        name = namelist[(int) (Math.random() * 13)];
        post = postlist[(int) (Math.random() * 6)];
        String[] bufArr = name.split(" ");
        email = bufArr[0] + "." + bufArr[1] + "@geekbrains.com";
        phoneNum = "+7" + (long) (Math.random() * 9619998877L);
        salary = (int) (Math.random() * 100000+50000);
        age = (int) (Math.random() *70+18);


    }

    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printInfo() {
        System.out.println("*********************************");
        System.out.println("name= " + name);
        System.out.println("post= " + post);
        System.out.println("email= " + email);
        System.out.println("phoneNum= " + phoneNum);
        System.out.println("salary= " + salary);
        System.out.println("age= " + age);
        System.out.println("*********************************");
    }

    public static boolean isAgeOver40(int age) {
        if (age>40) return true;
        else return false;
    }

    //4. Создать массив из 5 сотрудников.
    public static void main(String[] args) {
        Person[] persArr = new Person[5];
        for (int i = 0; i < 5; i++) {
            persArr[i]=new Person();
            //persArr[i].printInfo();
        }
        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

        System.out.println("5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.");
        for (int i = 0; i < 5; i++) {
            if (isAgeOver40(persArr[i].age)) {
               persArr[i].printInfo();
            }
        }
    }
}
