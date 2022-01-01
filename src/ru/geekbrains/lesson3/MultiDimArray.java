package ru.geekbrains.lesson3;

import java.util.Arrays;

public class MultiDimArray {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]+" ");
                // или System.out.println(Arrays.toString(array[i]));
            }
            System.out.println();
        }
        int[][] newArray = new int[5][];
        newArray[1] = new int[] {1,2,4};



    }


}
