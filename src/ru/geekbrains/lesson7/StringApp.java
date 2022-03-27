package ru.geekbrains.lesson7;

import java.util.Arrays;
import java.util.Locale;

public class StringApp {
    public static void main(String[] args) {
        String str= "String";
        System.out.println(Arrays.toString(str.toCharArray()));
        String str2= new String(str.toCharArray());

        str.toUpperCase();
        System.out.println(str+"  "+str.toUpperCase());

        StringBuilder sb = new StringBuilder();
        sb.append(1).append("  ").append(2);
        str2=sb.toString();
        System.out.println("sb=str2="+str2);

    }
}
