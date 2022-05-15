package ru.GB.LVL3.Lesson1.Homework;

public class Task1app {

    public static void main(String[] args) {
        String str0= new String();
        str0="str0";
        String str1= new String();
        str1="str1";
        String str2= new String();
        str2="str2";
        String[] strAr;
        strAr = new String[]{str0,str1,str2};

        Task1Objects<String> objects = new Task1Objects<String>(strAr);
        objects.swapObjects(1,2);

        objects.printObjectsArray();


    }

}
