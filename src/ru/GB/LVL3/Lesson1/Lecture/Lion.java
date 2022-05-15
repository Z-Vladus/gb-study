package ru.GB.LVL3.Lesson1.Lecture;

public class Lion extends Animal{

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void feed() {
        System.out.println("I eat meat");
    }


}
