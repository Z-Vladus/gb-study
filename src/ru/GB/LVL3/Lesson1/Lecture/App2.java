package ru.GB.LVL3.Lesson1.Lecture;

import java.util.TreeSet;

public class App2 {
    public static void main(String[] args) {
        // так нельзя!
        //Zoo<String> str = new Zoo<>();
        //Zoo<Integer> i = new Zoo<>();
        // так можно. это потомки Animal. (Zoo теперь extends Animal)
        Zoo<Animal> a = new Zoo<>();
        Zoo<Snake> s = new Zoo<>();
        Zoo<Elephant> e = new Zoo<>();
        TreeSet<CatLVL3>catLVL3s = new TreeSet<>();
        catLVL3s.add(new CatLVL3(3d));
        catLVL3s.add(new CatLVL3(1d));
        catLVL3s.add(new CatLVL3(5d));
        catLVL3s.add(new CatLVL3(8d));
        catLVL3s.add(new CatLVL3(9d));
        System.out.println(catLVL3s);


    }
}
