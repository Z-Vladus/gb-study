package ru.GB.LVL2.Lesson1Gusev;

public class User {
    private int id;
    private String name;
    private int age;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id) {
        this.id = id;
        this.name = "default";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAgeBefore18() {
        if (age>=18) return 0;
        else return 18-age;

    }

}
