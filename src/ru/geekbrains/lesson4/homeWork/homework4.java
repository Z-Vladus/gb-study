package ru.geekbrains.lesson4.homeWork;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework4 {

    public static char[][] map;
    public static boolean gameOver = false;

    public static final int SZ = 3;
    public static final int SZ_WIN = 3;
    public static final char fX = 'X';
    public static final char f0 = '0';
    public static final char fC = '*';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random rnd = new Random();

    public static void initMap() {
        map = new char[SZ][SZ];
        System.out.println("init map with SZ=" + SZ);
        for (int i = 0; i < SZ; i++) {
            Arrays.fill(map[i], fC);
        }
    }

    public static void printMap() {

        for (int i = 0; i < SZ; i++) {
            for (int j = 0; j < SZ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void winState() {

    }

    public static boolean isValid(int x, int y) {
        if ((x >= 0) && (x < SZ) && (y >= 0) && (y < SZ) && (map[x][y] == fC)) {
            return true;
        }
        System.out.println("x=" + x + " y=" + y + " are not valid coords");
        return false;

    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("enter row [0.." + (SZ - 1) + "] and column [0.." + (SZ - 1) + "] : ");
            x = SCANNER.nextInt();
            y = SCANNER.nextInt();
        } while (!isValid(x, y));
        map[x][y] = fX;
    }

    public static void robotTurn() {
        int x, y;
        do {

            x = rnd.nextInt(SZ);
            y = rnd.nextInt(SZ);
        } while (!isValid(x, y));
        map[x][y] = f0;
        System.out.println("robot move x=" + x + " y=" + y);
    }

    /**
     * @return возвращает 0 - игра не окончена, 1 - победил человек, 2 - победил робот 3- ничья
     */

    public static int checkWinFullSquare() {
        char buf;
        int player; // = 1 если человек, = 2 если робот
        int result = 0;

        result = checkWinByFullRow();
        if (result != 3) {
            gameOver = true;
            return result;
        }

        result = checkWinByFullColumn();
        if (result != 3) {
            gameOver = true;
            return result;
        }

        result = checkWinByFull1stDiag();
        if (result != 3) {
            gameOver = true;
            return result;
        }

        result = checkWinByFull2ndDiag();
        if (result != 3) {
            gameOver = true;
            return result;
        }

        if (checkDraw()) return 3;

        return 0;
    }

    /**
     * кто выиграл по 2й диагонали ?
     *
     * @return 1-человек 2- робот 3- нет выигрывшего
     */
    private static int checkWinByFull2ndDiag() {
        char buf;
        int player; // = 1  человек, = 2  робот

        buf = map[0][SZ - 1];
        if (buf == fX) {
            player = 1;
        } else if (buf == f0) {
            player = 2;
        } else {
            return 3;
        }
        boolean winFlag = true;
        for (int i = SZ - 1; i >= 0; i--) {
            int j = SZ - 1 - i;
            if (i + j == SZ - 1) {
                if (map[i][j] == buf) {
                    winFlag = true;
                } else {
                    winFlag = false;
                    break;
                }
            }

        }

        if (winFlag == true) {
            System.out.println("player " + player + " win by 2nd diag");
            return player;
        }
        return 3;
    }

    /**
     * кто выиграл по 1й диагонали ?
     *
     * @return 1-человек 2- робот 3- нет выигрывшего
     */
    private static int checkWinByFull1stDiag() {
        char buf;
        int player; // = 1  человек, = 2  робот

        buf = map[0][0];
        boolean winFlag = true;

        if (buf == fX) {
            player = 1;
        } else if (buf == f0) {
            player = 2;
        } else {
            return 3;
        }

        for (int i = 1; i < SZ; i++) {
            int j = i;
            if (map[i][j] == buf) {
                winFlag = true;
            } else {
                winFlag = false;
                break;
            }
        }

        if (winFlag == true) {
            System.out.println("player " + player + " win by 1st diag");
            return player;
        }
        return 3;
    }

    /**
     * кто выиграл по вертикали?
     *
     * @return 1-человек 2- робот 3- нет выигрывшего
     */
    private static int checkWinByFullColumn() {
        char buf;
        int player, i;
        for (i = 0; i < SZ; i++) {
            //чьё поле?
            buf = map[0][i];
            if (buf == fX) {
                player = 1;
            } else if (buf == f0) {
                player = 2;
            } else {
                continue;
            }

            int l = 0;
            boolean winFlag = true;
            do {
                if (buf == map[l][i]) {
                    winFlag = true;
                } else {
                    winFlag = false;
                    break;
                }
                l++;
            } while (winFlag && (l < SZ));

            if (winFlag == true) {
                System.out.println("player " + player + " win by " + i + " column ");
                return player;
            }

        }
        return 3;
    }

    /**
     * кто выиграл по горизонтали?
     *
     * @return 1-человек 2- робот 3- нет выигрывшего
     */
    public static int checkWinByFullRow() {
        char buf;
        int player;
        int i;
        for (i = 0; i < SZ; i++) {
            //чьё поле?
            buf = map[i][0];
            if (buf == fX) {
                player = 1;
            } else if (buf == f0) {
                player = 2;
            } else {
                //player=0;
                continue;
            }

            int l = 0;
            boolean winFlag = true;
            do {
                if (buf == map[i][l]) {
                    winFlag = true;
                } else {
                    winFlag = false;
                    break;
                }
                l++;
            } while (winFlag && (l < SZ));

            if (winFlag == true) {
                System.out.println("player " + player + " win by " + i + " row ");
                return player;
            }

        }
        return 3;
    }


    public static boolean checkDraw() {
        for (int i = 0; i < SZ; i++) {
            for (int j = 0; j < SZ; j++) {
                if (map[i][j] == fC) {
                    return false;
                }
            }
        }
        gameOver = true;
        return true;
    }



    /** ...увы, кастомное число фишек не успел
     * @return возвращает 0 - игра не окончена, 1 - победил человек, 2 - победил робот 3- ничья
     */

    public static int checkWinCustom() {
    /*    char buf;
        int player; // = 1 если человек, = 2 если робот


        for (int k = 0; k < SZ; k++) {
            int l=0;
            do {
                l++;
            } while (l+);
        }

        for (int i = 0; i < SZ; i++) {
            for (int j = 0; j < SZ; j++) {
                buf=map[i][j];
                //чьё поле?
                if (buf == fX ) {
                    player=1;
                } else if (buf == f0 ) {
                    player=2;
                } else {
                    player=0;
                }
                // проверяем выигрыш о горизонталям
                // k - цикл по всем строкам.
                // l - цикл по всем элементам в левой части, с которых может начинаться выигрышная горизонталь.
                // например если поле 5х5 и кол-во фишек 4, то горизонталь может быть с 0-го и с 1-го столбцов,
                // до 3-го или 4-го соответственно
                for (int k = 0; k < SZ; k++) {
                    int l=0;
                    do {
                        l++;
                    } while (l+);
                }
            }
        }
        */
        return 0;
    }

    public static void main(String[] args) {
        initMap();
        printMap();

        for (int i = 0; i < 5; i++) {
            humanTurn();
            printMap();
            switch (checkWinFullSquare()) {
                case 0 -> {
                    System.out.println("game on");
                    break;
                }
                case 1 -> {
                    System.out.println("human wins");
                    break;
                }
                case 2 -> {
                    System.out.println("robot wins");
                    break;
                }
            }
            if (gameOver) break;
            robotTurn();
            printMap();
            switch (checkWinFullSquare()) {
                case 0 -> {
                    System.out.println("game on");
                    break;
                }
                case 1 -> {
                    System.out.println("human wins");
                    break;
                }
                case 2 -> {
                    System.out.println("robot wins");
                    break;
                }
            }
            if (gameOver) break;

        }

    }

}
