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

        // в общий зоопарк можно любого наследника класса Animal поместить
        /*boolean lion = zoo.encage(new Lion("Simba", 3));
        boolean python = zoo.encage(new Snake("Kaa", 200));
        boolean elephant = zoo.encage(new Lion("Jambo", 40));
        */
        Lion lion = new Lion("Simba", 3);
        //zoo.encage(new Lion("Simba", 3));
        zoo.encage(new Snake("Kaa", 200));
        zoo.encage(new Lion("Jambo", 40));
        // нужно избегать возврата потомственных классов.
        // Зоопарк для животных = работать желательно только как с животными.
        Animal releasedAnimal = zoo.release(lion);

        // змеевой зоопарк принимает только змей!
        Zoo<Snake> serpentarium =new Zoo<>();
        serpentarium.encage(new Snake("Нагайна",3));

        // реализация factory-метода.
        // по-умолчанию, ИДЕЯ даёт Object.
        //Zoo<Object> objectZoo = Zoo.zooCreate(); //(с Zoo extends Animal не работает)
        // но можно и так. В zooCreate() компилятор подставит то что в левой части в <...>
        final Zoo<Animal> objectZoo2 = Zoo.zooCreate();

        // пример использования параметризованного метода
        // здесь видим, что компилятор сам понимает какие типы пойдут в какие параметры
        App app = new App();
        app.print1("foo",1);
        app.print1(2,"bar");

        // *** Лекция 1:30 инвариантность и ковариантность ******

        // массивы - ковариантны
        Object[] a = new String[10];
        a[1]  = "foo bar";
        // такое откомпилируется, но в рантайме упадёт!
        a[2] = 2;
        // Джереники - инвариантны как и коллекции
        //ArrayList<Object> o = new ArrayList<String>(); // инвариантность

        // иными словами, массив строк это массив обжектов, это норм. Но коллекция строк - не коллекция обжектов
        Animal[] animals = new Lion[5]; // ковариантность
        //Zoo<Animal> animalZoo = new Zoo<Lion>(); // инвариантность , не скомпилируется.

        // если имплементирован абстр. класс feed()...
        ArrayList<Animal> animals1 = new ArrayList<>();
        animals1.add(new Lion("Симба",4));
        animals1.add(new Snake("kaa",4));
        animals1.add(new Elephant("Джамбо",4));
        //то вот такое - норм
        app.feedAnimals(animals1);
        // а вот так - не получится.
        ArrayList<Snake> snakes = new ArrayList<>();
        snakes.add( new Snake("kaa1",5));
        snakes.add( new Snake("kaa2",6));
        //app.feedAnimals(snakes);
        // ^^ List<Animal> - не может быть представлен как List<Snake>, ошибка компиляции
        // но выход- есть - вайлдкарты
        List<? extends Animal> wildList = new ArrayList<Animal>();
        // ещё примеры
        List<? extends Animal> wildListLions = new ArrayList<Lion>();
        List<? extends Animal> wildListSnakes = new ArrayList<Snake>();
        List<? extends Animal> wildListElephants = new ArrayList<Elephant>();

        app.feedAnimalsWildcarded(wildList);
        // положить в эту коллекцию ничего нельзя вот так ->
        //wildList.add(new Snake("123",3));
        // можем только прочитать.

        // для добавления в такие коллекции нужен другой вайлд кард.
        List<? super Animal> wildSuperList = new ArrayList<Animal>();
        List<? super Animal> wildSuperList2 = new ArrayList<Object>();
        wildSuperList.add(new Snake("kaa",4));

        // рассмотрим пример
        // PECS:
        // producer extends
        // Consumer - super

        List<Animal> dst = new ArrayList<>();
        System.out.println("dst size= " + dst.size());
        dst.add(null); dst.add(null); dst.add(null); // добавим три позиции. коллекции должны быть одинаковыми в размерах
        System.out.println("dst size= " + dst.size());
        System.out.println("animals1 size= " + animals1.size());
        Collections.copy(dst,animals1);
        // ^^ норм
        final List<Lion> lionsList = Arrays.asList(new Lion("LLL",3));
        final List<Snake> snakesList = new ArrayList<>();
        // при попытке скопировать львов в змей - ничего не получится
        //Collections.copy(snakesList,lionsList);
        // но копировать львов в коллекцию животных - можно.
        final List<Animal> animalsList = new ArrayList<>();
        Collections.copy(animalsList,lionsList);
        // ^^ норм!




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

    private void feedAnimalsWildcarded(List<? extends Animal> animals){ // коллекция-producer (производитель), только даёт данные
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    private void superMethod(List<? super Animal> animals) { // коллекция consumer (потребитель)

    }
}
