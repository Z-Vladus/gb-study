package ru.GB.LVL3.Lesson1;

public class CatLVL3 implements Comparable<CatLVL3>{
    private double weight;

    public CatLVL3(double weight){
        this.weight=weight;
    }

    @Override
    public int compareTo(CatLVL3 o) {
        return (int)(weight - o.weight);
    }
}
