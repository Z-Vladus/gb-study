package ru.GB.LVL1.lesson3;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        int[] array = new int[5];
        printArray(array);
        array[2]=199;
        array[array.length-1]=100;

        for (int i = 0; i < array.length; i++) {
            array[i]=100+i*100;
        }
        printArray(array);
        String[] strings = new String[10];

        strings[1]="1st";
        strings[2]="2nd";
        strings[3]="3rd";
        System.out.println("System.out.println(Arrays.toString(strings));");
        System.out.println(Arrays.toString(strings));

    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");

        }
        System.out.println();
    }
}
