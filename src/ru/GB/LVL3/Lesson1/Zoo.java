package ru.GB.LVL3.Lesson1;

import java.util.ArrayList;
import java.util.List;

//public class Zoo<T extends Animal> {
public class Zoo<T> {
    private List<T> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public boolean encage(T animal) {
        return animals.add(animal);
    }

    public T release(T animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            return animal;
        }
        return null;
    }

    //����������� ������ � ����������� ������ ������������.
    // �� ����� ��������������� ����� �������.
    public static <V> void create(V animal) {
    }
    // ����� � �������������
    public <V> void create1(V animal) {
    }

    //factory-����� (�������� ��� �����������)

    public static<V> Zoo<V> zooCreate() {
        return new Zoo<V>();

    }
}
