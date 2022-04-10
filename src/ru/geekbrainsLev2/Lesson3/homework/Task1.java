package ru.geekbrainsLev2.Lesson3.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task1 {
    /*
    Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
    вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.
    */

    public static void main(String[] args) {
        String str = "слово слово Создать массив с набором слов от десяти до двадцати слов Должны встречаться повторяющиеся Найти и " +
                "вывести список уникальных слов из которых состоит массив Дубликаты не считаем " +
                "Посчитать сколько раз встречается каждое слово слово слово слово слово слово слово";

        String[] strarr = str.split(" ");
        List<String> words = new ArrayList<>();
        List<Integer> wordsCounter = new ArrayList<>();

        // что у нас получилось
        System.out.println("Массив слов длина=" +strarr.length);
        for (int i = 0; i < strarr.length; i++) {
            System.out.print(strarr[i]+" ");
            if (!words.contains(strarr[i])) {
                words.add(strarr[i]);
                // в соответствующее поле счётчиков ставим 1. все слова встречаются минимум 1 раз
                wordsCounter.add(1);
            } else {
                //j = найдём повторяющеейся слово
                int j = words.indexOf(strarr[i]);
                // в соответствующее поле счётчиков прибавим 1.
                wordsCounter.set(j,wordsCounter.get(j)+1);
            }
        }

        System.out.println();
        System.out.println("Набор уникальных слов длина = "+words.size());
        System.out.println("Набор уникальных слов = ");
        System.out.println(words);
        System.out.println("Счётчик слов = ");
        for (int i = 0; i < words.size(); i++) {
            System.out.println("\""+words.get(i)+"\"" + " встречается "+ wordsCounter.get(i)+" раз");
        }


    }

}
