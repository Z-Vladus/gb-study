package ru.geekbrains.lesson3.homework;

import java.util.Arrays;

public class homework3 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = {1, 1, 1, 0, 0, 1, 0, 1, 1, 0};
        System.out.println("1st task");
        System.out.println("arr before inversion");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(" ^ ^ ^ ^ ^ ^");
        System.out.println("arr after inversion");
        System.out.println("===============================");

        // 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        System.out.println("2nd task");
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println("2nd task result=");
        System.out.println(Arrays.toString(arr2));
        System.out.println("===============================");
        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("3rd task");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("arr3 before modify");
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 6;
            }
        }
        System.out.println("3rd task result=");
        System.out.println(Arrays.toString(arr3));
        System.out.println("===============================");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        // заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу:
        // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        System.out.println("4th task");
        System.out.println("4th task result=");
        int[][] arr4 = new int[15][15];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if ((i == j) || ((i + j) == arr4.length - 1)) arr4[i][j] = 1;
            }
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println("===============================");

        //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
        // одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        System.out.println("5th task");
        int[] arr5;
        int len = (int) (Math.random() * 7 + 3);
        int initialValue = (int) (Math.random() * 10);
        arr5 = method5(len, initialValue);
        System.out.println("len=" + len + " initialValue=" + initialValue);
        System.out.println(Arrays.toString(arr5));
        System.out.println("===============================");

        //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        System.out.println("6th* task");
        int max, min;

        int[] arr6 = new int[15];
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = (int) (Math.random() * 50);
        }
        System.out.println("generated arr6:");
        System.out.println(Arrays.toString(arr6));
        max = arr6[0];
        min = arr6[0];
        for (int i = 0; i < arr6.length; i++) {
            System.out.println("arr6[" + i + "]=" + arr6[i]);
            if (max < arr6[i]) {
                max = arr6[i];
                System.out.println("new max=" + max);
            }
            if (min > arr6[i]) {
                min = arr6[i];
                System.out.println("new min=" + min);
            }

        }
        System.out.println("Result max=" + max + " min=" + min);
        System.out.println("===============================");
        //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        System.out.println("7th** task");


        int[] arr7 = {2, 2, 2, 1, 2, 2, 10, 1};
        //int[] arr7 = {1, 1, 1, 2, 1};
        //int[] arr7 = {4, 1, 1, 1, 1};
        //int[] arr7 = {90, 9, 0, 0, 99};

        /*int[] arr7 = new int[5];
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = (int) (Math.random()*10);
        }
        System.out.println("random generated arr7 :");*/
        System.out.println("arr7 = " + Arrays.toString(arr7));
        System.out.println("method7 returned " + method7(arr7));
        System.out.println("===============================");

        //8. *** Написать метод, которому на вход подается одномерный массив
        //  и число n (может быть положительным, или отрицательным),
        //  при этом метод должен сместить все элементы массива на n позиций.
        //  Элементы смещаются циклично.
        //  Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        //  Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        //  [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        //  При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("8th***  task");
        int[] arr8 = new int[10];
        int[] arr8_init = new int[10];
        for (int i = 0; i < arr8.length; i++) {
            arr8[i] = (int) (Math.random()*50);
            arr8_init[i]=arr8[i];
        }

        System.out.println("calling method8(arr8, -3); result=");
        method8(arr8, -3);
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.toString(arr8_init));
        System.out.println(" ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^");
        System.out.println("^ initial array for comparison ^");

        System.out.println("calling method8(arr8, 2); result=");
        method8(arr8, 2);
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.toString(arr8_init));
        System.out.println(" ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^");
        System.out.println("^ initial array for comparison ^");

        System.out.println("calling method8(arr8, 0); result=");
        method8(arr8, 0);
    }

    public static int[] method5(int len, int initialValue) {
        int[] arrm5 = new int[len];
        Arrays.fill(arrm5, initialValue);
        return arrm5;
    }


    public static boolean method7(int[] arrm7) {
        int left_sum = arrm7[0], right_sum = arrm7[arrm7.length - 1];
        System.out.println(" Before loops: left_sum=" + left_sum + " right_sum=" + right_sum);

        for (int i = 0; i < arrm7.length - 1; i++) {
            //вычисляем левую часть
            left_sum = 0;
            right_sum = 0;
            for (int j = 0; j <= i; j++) {
                left_sum += arrm7[j];
                System.out.println("debug: i=" + i + " j=" + j + " left_sum=" + left_sum);
            }
            //вычисляем правую часть
            for (int j = i + 1; j < arrm7.length; j++) {
                right_sum += arrm7[j];
                System.out.println("debug: i=" + i + " j=" + j + " right_sum=" + right_sum);
            }
            System.out.println("iteration " + i + " result: left_sum=" + left_sum + " right_sum=" + right_sum);
            if (left_sum == right_sum) return true;
        }
        // если места не нашлось, возврат ложь
        return false;
    }


    //  Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    //  [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    public static void method8(int[] arrm8, int n) {
        int buf1;
        // циклический сдвиг всего массива а-ля пятняшки, с одним буфером.
        // если сдвиг вправо (n>0)
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                //перемещаем последний эл-т в в буфер
                buf1 = arrm8[arrm8.length - 1];
                /*
                System.out.println("Array before loop:");
                System.out.println(Arrays.toString(arrm8));
                System.out.println("Loop starts:");
                */
                for (int j = arrm8.length - 1; j > 0; j--) {
                    //System.out.println("i=" + i + " j=" + j + " buf1=" + buf1);
                    arrm8[j] = arrm8[j - 1];
                    /*
                    System.out.println("j-loop iteration result:");
                    System.out.println(Arrays.toString(arrm8));
                    */
                }
                //из буфера вставляем в 0й элемент
                arrm8[0] = buf1;
            }
        }
        // если сдвиг влево (n<0)
        if (n < 0) {
            for (int i = 0; i < n * -1; i++) {
                //перемещаем 0й эл-т в в буфер
                buf1 = arrm8[0];
                /*
                System.out.println("Array before loop:");
                System.out.println(Arrays.toString(arrm8));
                System.out.println("Loop starts:");
                */

                //меняем 1-й элемент на 2-й, 2-й на 3-й и т.д.
                for (int j = 0; j < arrm8.length - 1; j++) {
                    //System.out.println("i=" + i + " j=" + j + " buf1=" + buf1);
                    arrm8[j] = arrm8[j + 1];
                    /*System.out.println("j-loop iteration result:");
                    System.out.println(Arrays.toString(arrm8));*/
                }
                //из буфера вставляем в последний элемент
                arrm8[arrm8.length - 1] = buf1;
            }
        }
        if (n == 0) {
            System.out.println("0 - недопустимое значение, вторым аргументом нужно целое число");
        }

    }
}


