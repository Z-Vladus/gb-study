package ru.GB.LVL2.Lesson1Gusev.Interfaces;

public class App {
    public static void main(String[] args) {
        Student st = new Student();
        Pupil p = new Pupil();
        Studyable[] studyables = new Studyable[] {st,p};
        for (Studyable studyable : studyables) {
            studyable.study();
        }
    }

}
