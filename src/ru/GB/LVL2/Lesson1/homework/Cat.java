package ru.GB.LVL2.Lesson1.homework;

public class Cat implements Trainable {
    private String name;
    private int jumpAbility;
    private int runAbility;

    @Override
    public boolean jump(int jumpHeight) {
        System.out.print(name+" может перепрыгнуть стену "+jumpAbility+ " м., а стена "+jumpHeight+" м. " );
        if (jumpHeight>jumpAbility) {
            System.out.println(name+" не смог!");
            return(false);
        } else {
            System.out.println(name+" перепрыгнул!");
            return(true);
        }

    }

    @Override
    public boolean run(int runDist) {
        System.out.print(name+" может пробежать "+runAbility+ " м., а дистанция="+runDist+" м. ... ");
        if (runDist>runAbility) {
            System.out.println(name+" не смог пробежать.");
            return(false);
        } else {
            System.out.println(name+" пробежал успешно!");
            return(true);
        }
    }

    public int getJumpAbility() {
        return jumpAbility;
    }

    public void setJumpAbility(int jumpAbility) {
        this.jumpAbility = jumpAbility;
    }

    public int getRunAbility() {
        return runAbility;
    }

    public void setRunAbility(int runAbility) {
        this.runAbility = runAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
