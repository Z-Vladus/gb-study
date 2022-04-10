package ru.GB.LVL2.Lesson1Gusev.Interfaces;

public class Student implements Studyable, HardWorkable {
//    @Override
//    public void study() {
//        System.out.println("Студент учится");
//    }


    @Override
    public void study() {
        System.out.println("Студент учится");

    }

    @Override
    public void work() {
        System.out.println("Студент работает");

    }

    public void workHard() {
        System.out.println("Студент работает много");
    }

}
