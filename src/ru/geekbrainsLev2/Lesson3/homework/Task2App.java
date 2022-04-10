package ru.geekbrainsLev2.Lesson3.homework;

public class Task2App {

    public static void main(String[] args) {

       PhoneBook pb=new PhoneBook();
       pb.add("102","Полиция");
       pb.add("102","ОМОН");
       pb.add("103","Скорая помощь");
       pb.add("104","Газовая служба");

       System.out.println(pb.get(""));


    }
}
