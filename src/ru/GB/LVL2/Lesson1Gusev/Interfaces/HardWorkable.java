package ru.GB.LVL2.Lesson1Gusev.Interfaces;

public interface HardWorkable extends Workable {
    void workHard();
    default void worfVeryHard(){
        System.out.println("по умолчанию оч тяжело");
    };

}
