package ru.geekbrains.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CrossesZeroesApp {

    //поле
    public static char[][] map;
    public static final int SIZE = 3;
    // условие  победы
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i],DOT_EMPTY);
        }
    }
    public static void initMap2() {
        //map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=42;
            }

        }
    }

    public static void printMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x,y;
        do {
            System.out.println("enter x, y");
            x=SCANNER.nextInt()-1;
            y=SCANNER.nextInt()-1;

        } while (!isCellValid(x,y));
        map[y][x]=DOT_X;
    }

    public static boolean isCellValid (int x, int y) {
        if (x<0 || x>=SIZE || y<0 || y >= SIZE ) {
            return false;
        }
        if ((map[y][x]) != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    public static void aiTurn () {
        int x,y;
        do {
            x=RANDOM.nextInt(SIZE);
            y=RANDOM.nextInt(SIZE);
        } while (!isCellValid(x,y));
        System.out.println("Robot moves "+(x+1) + " " + (y+1));
        map[y][x]=DOT_0;
    }

    public static boolean checkWin(char symbol) {
        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) {
            return true;
        }
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) {
            return true;
        }
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) {
            return true;
        }
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) {
            return true;
        }
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) {
            return true;
        }
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) {
            return true;
        }
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) {
            return true;
        }
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) {
            return true;
        }
        return false;
    }


    public static boolean isMapfull () {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]==DOT_EMPTY) {
                    return false;
                }


            }

        }
        return true;
    }



    public static void main(String[] args) {
        map = new char[SIZE][SIZE];
        initMap2();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("human wins");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_0)) {
                System.out.println("robot wins");
                break;
            }
        }


    }
}
