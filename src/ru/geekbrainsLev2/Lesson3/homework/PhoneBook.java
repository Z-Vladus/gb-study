package ru.geekbrainsLev2.Lesson3.homework;

import java.util.HashMap;

public class PhoneBook {
    // Хэшмап фамилия - телефоны

    private HashMap<String,String> hm =new HashMap<>();

    public void add(String phone , String name){
        hm.put(phone,name);
    }

    public String get(String phone){
        String res;
        res=hm.get(phone);
        return res;
    }

    public void setHm(HashMap<String, String> hm) {
        this.hm = hm;
    }

    /*
     Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
справочника.

    * */




}
