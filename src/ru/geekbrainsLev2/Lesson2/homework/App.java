package ru.geekbrainsLev2.Lesson2.homework;

/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
при условии что подали на вход корректный массив).

 */

public class App {

    public static void arrConv (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length!=4)
            throw new MyArraySizeException("строк не 4");
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length!=4)
                    throw new MyArraySizeException("столбцов не 4");
            }
        }
        int sum=0;
        Integer buf;

        arr[2][3]="тестовая абракадабра";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    buf=Integer.parseInt(arr[i][j]);
                    sum=sum+buf;
                    System.out.println("sum="+sum);
                } catch ( NumberFormatException e) {
                    System.out.println("строку невозможно преобразовать в int");
                    throw new MyArrayDataException("строку невозможно преобразовать в int. Ошибка в ячейках "+i+","+j);
                }

            }
        }
        System.out.println("final sum="+sum);
    }

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr3 = new String[3][3];
        String[][] arr4 = new String[4][4];

        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length  ; j++) {
                Integer a = ((int)(Math.random()*1000));
                arr3[i][j]= a.toString();
                System.out.print(arr3[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("*********************");

        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length  ; j++) {
                Integer a = ((int)(Math.random()*1000));
                arr4[i][j]= a.toString();
                System.out.print(arr4[i][j]+ " ");
            }
            System.out.println();
        }

        //пробуем подать неверный массив
        arrConv(arr3);


        //пробуем подать верный массив
        arrConv(arr4);

    }
}
