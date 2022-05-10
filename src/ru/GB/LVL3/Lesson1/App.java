package ru.GB.LVL3.Lesson1;
// Lesson 3-1 GENERICS

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        /*
        final Zoo<String> zoo = new Zoo<>();
        final Zoo<Integer> zoo1 = new Zoo<>();
        zoo.encage("abc");
        zoo1.encage(1);
        String a = zoo.release("abc");
        Integer b = zoo1.release(2);
        */

        Zoo<Animal> zoo = new Zoo<>();

        // � ����� ������� ����� ������ ���������� ������ Animal ���������
        /*boolean lion = zoo.encage(new Lion("Simba", 3));
        boolean python = zoo.encage(new Snake("Kaa", 200));
        boolean elephant = zoo.encage(new Lion("Jambo", 40));
        */
        Lion lion = new Lion("Simba", 3);
        //zoo.encage(new Lion("Simba", 3));
        zoo.encage(new Snake("Kaa", 200));
        zoo.encage(new Lion("Jambo", 40));
        // ����� �������� �������� ������������� �������.
        // ������� ��� �������� = �������� ���������� ������ ��� � ���������.
        Animal releasedAnimal = zoo.release(lion);

        // ������� ������� ��������� ������ ����!
        Zoo<Snake> serpentarium =new Zoo<>();
        serpentarium.encage(new Snake("�������",3));

        // ���������� factory-������.
        // ��-���������, ���� ��� Object.
        //Zoo<Object> objectZoo = Zoo.zooCreate(); //(� Zoo extends Animal �� ��������)
        // �� ����� � ���. � zooCreate() ���������� ��������� �� ��� � ����� ����� � <...>
        final Zoo<Animal> objectZoo2 = Zoo.zooCreate();

        // ������ ������������� ������������������ ������
        // ����� �����, ��� ���������� ��� �������� ����� ���� ������ � ����� ���������
        App app = new App();
        app.print1("foo",1);
        app.print1(2,"bar");

        // *** ������ 1:30 �������������� � �������������� ******

        // ������� - �����������
        Object[] a = new String[10];
        a[1]  = "foo bar";
        // ����� ���������������, �� � �������� �����!
        a[2] = 2;
        // ��������� - ����������� ��� � ���������
        //ArrayList<Object> o = new ArrayList<String>(); // ��������������

        // ����� �������, ������ ����� ��� ������ ��������, ��� ����. �� ��������� ����� - �� ��������� ��������
        Animal[] animals = new Lion[5]; // ��������������
        //Zoo<Animal> animalZoo = new Zoo<Lion>(); // �������������� , �� ��������������.

        // ���� ��������������� �����. ����� feed()...
        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Lion("�����",4));
        animals1.add(new Snake("kaa",4));
        animals1.add(new Elephant("������",4));
        //�� ��� ����� - ����
        app.feedAnimals(animals1);
        // � ��� ��� - �� ���������.
        ArrayList<Snake> snakes = new ArrayList<>();
        snakes.add( new Snake("kaa1",5));
        snakes.add( new Snake("kaa2",6));
        //app.feedAnimals(snakes);
        // ^^ List<Animal> - �� ����� ���� ����������� ��� List<Snake>, ������ ����������
        // �� �����- ���� - ����������
        List<? extends Animal> wildList = new ArrayList<Animal>();
        // ��� �������
        List<? extends Animal> wildListLions = new ArrayList<Lion>();
        List<? extends Animal> wildListSnakes = new ArrayList<Snake>();
        List<? extends Animal> wildListElephants = new ArrayList<Elephant>();

        app.feedAnimalsWildcarded(wildList);
        // �������� � ��� ��������� ������ ������ ��� ��� ->
        //wildList.add(new Snake("123",3));
        // ����� ������ ���������.

        // ��� ���������� � ����� ��������� ����� ������ ����� ����.
        List<? super Animal> wildSuperList = new ArrayList<Animal>();
        List<? super Animal> wildSuperList2 = new ArrayList<Object>();
        wildSuperList.add(new Snake("kaa",4));

        // ���������� ������
        // PECS:
        // producer extends
        // Consumer - super

        List<Animal> dst = new ArrayList<>();
        System.out.println("dst size= " + dst.size());
        dst.add(null); dst.add(null); dst.add(null); // ������� ��� �������. ��������� ������ ���� ����������� � ��������
        System.out.println("dst size= " + dst.size());
        System.out.println("animals1 size= " + animals1.size());
        Collections.copy(dst,animals1);
        // ^^ ����
        final List<Lion> lionsList = Arrays.asList(new Lion("LLL",3));
        final List<Snake> snakesList = new ArrayList<>();
        // ��� ������� ����������� ����� � ���� - ������ �� ���������
        //Collections.copy(snakesList,lionsList);
        // �� ���������� ����� � ��������� �������� - �����.
        final List<Animal> animalsList = new ArrayList<>();
        Collections.copy(animalsList,lionsList);
        // ^^ ����!




    }
    private <S,T> S print1(S t1, T t2) {
        System.out.println(t1 + " + " + t2);
        return null;

    }
    private void feedAnimals(ArrayList<Animal> animals){
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    private void feedAnimalsWildcarded(List<? extends Animal> animals){ // ���������-producer (�������������), ������ ��� ������
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    private void superMethod(List<? super Animal> animals) { // ��������� consumer (�����������)

    }
}
