package ru.geekbrainsLev1.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("домашка №1 от 25.12.2021");
        PrintThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void PrintThreeWords() {
        System.out.println("метод PrintThreeWords - ПОЕХАЛИ!!");
        System.out.println("""
                Orange
                Banana
                Apple""");
    }

    public static void checkSumSign() {
        System.out.println("checkSumSign - ПОЕХАЛИ!!");
        int a, b;
        a = (int) (Math.random() * 10) - 5;
        b = (int) (Math.random() * 10) - 5;
        System.out.println("a=" + a + " b=" + b);
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        System.out.println("printColor - ПОЕХАЛИ!!");
        int value;
        value = (int) (Math.random() * 300) - 150;
        System.out.println("value=" + value);
        // что интересно, IDEA выдаёт warning "Condition 'value > 0' is always 'true'" но по факту всё работает.
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        System.out.println("compareNumbers - ПОЕХАЛИ!!");
        int a = (int) (Math.random() * 10) - 5;
        int b = (int) (Math.random() * 10) - 5;
        System.out.println("a=" + a + " b=" + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


}
