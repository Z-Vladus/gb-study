package ru.GB.LVL1.lesson2;

public class lesson2 {
    public static void main(String[] args) {
        System.out.println("## First task ##");
        // 1) Написать метод, принимающий на вход два целых числа и проверяющий,
        // что их сумма лежит в пределах от 10 до 20 (включительно),
        // если да – вернуть true, в противном случае – false.
        int x,y;
        for (int i = 0; i < 10; i++) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            System.out.println("x="+x+" y="+y);
            System.out.println("check1020(x,y)="+check1020(x,y));
        }
        System.out.println("## Second task ##");
        //Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
        // положительное ли число передали или отрицательное.
        // Замечание: ноль считаем положительным числом.

        for (int i = 0; i < 10; i++) {
            x = (int) ((Math.random() * 10)-5);
            System.out.print("x="+x+"; ");
            checkSign(x);
        }
        System.out.println("## Third task ##");
        //Написать метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        // хм , про ноль ничего? значит считаем положительным тоже
        for (int i = 0; i < 10; i++) {
            x = (int) ((Math.random() * 10)-5);
            System.out.println("x="+x+"; Is x positive? "+checkSignReturnBool(x));
        }

        System.out.println("## Fourth task ##");
        //Написать метод, которому в качестве аргументов передается строка и число,
        // метод должен отпечатать в консоль указанную строку, указанное количество раз;
        x=7;
        System.out.println("Printing string "+x+" times. Let's go!");
        printStrXtimes("Test string",x);

        System.out.println("## Fifth task ##");
        //* Написать метод, который определяет, является ли год високосным, и возвращает boolean
        // (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        // попробуем на примере 1950 - 2024 годов , 0-й, 1600й, 1900й
        for (int i = 1950; i <= 2024; i++) {
            System.out.println("checking year of "+i+". Is it leap year? "+checkYear(i));
        }
        x=0;
        System.out.println("checking year of " +x+  ". Is it leap year? "+checkYear(x));
        x=1600;
        System.out.println("checking year of " +x+  ". Is it leap year? "+checkYear(x));
        x=1900;
        System.out.println("checking year of " +x+  ". Is it leap year? "+checkYear(x));


    }



    public static boolean check1020(int x, int y) {
        return (x + y) >= 10 && (x + y) <= 20;

    }

    public static void checkSign(int x) {
        if (x >= 0 ) {
            System.out.println("x is positive or zero");
        } else {
            System.out.println("x is negative");
        }

    }

    public static boolean checkSignReturnBool (int x) {
        if (x >= 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static void printStrXtimes(String str, int x) {

        for (int i = 1; i <= x; i++) {
            System.out.println(str);
        }
    }

    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean checkYear (int x) {
        if ((x % 400) == 0) return true;
        if ((x % 100) == 0) return false;
        if ((x % 4) == 0) return true;
        return false;
    }

}
