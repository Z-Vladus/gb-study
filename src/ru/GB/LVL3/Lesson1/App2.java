package ru.GB.LVL3.Lesson1;

public class App2 {
    public static void main(String[] args) {
        // так нельзя!
        //Zoo<String> str = new Zoo<>();
        //Zoo<Integer> i = new Zoo<>();
        // так можно. это потомки Animal. (Zoo теперь extends Animal)
        Zoo<Animal> a = new Zoo<>();
        Zoo<Snake> s = new Zoo<>();
        Zoo<Elephant> e = new Zoo<>();

    }
}
