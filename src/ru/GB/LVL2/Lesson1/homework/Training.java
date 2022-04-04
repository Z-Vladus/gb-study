package ru.GB.LVL2.Lesson1.homework;

interface Trainable {
    boolean jump(int jumpHeight); // способность прыгать, в метрах
    boolean run(int runDist); // способность бежать, дистанция
}

/**
 * Класс для выполнения упражнений
 */
public class Training {
    public static void main(String[] args) {
        // создаём массив стен стены
        Wall[] walls = new Wall[10];
        // создаём беговые дорожки
        RunLine[] runLines = new RunLine[10];
        // Создаём котов, роботов, людей
        Cat cats[] =     new Cat[5];
        Robot robots[] = new Robot[5];
        Human humans[]=  new Human[5];
        for (int i = 0; i < 5; i++) {
            cats[i]=new Cat();
            cats[i].setName("Кот"+i);
            cats[i].setJumpAbility(1);
            cats[i].setRunAbility(71);


            robots[i]=new Robot();
            robots[i].setName("Робот"+i);
            robots[i].setJumpAbility(3);
            robots[i].setRunAbility(80);

            humans[i]=new Human();
            humans[i].setName("Человек"+i);
            humans[i].setJumpAbility(2);
            humans[i].setRunAbility(60);
        }

        // инициализируем стены
        for (int i = 0; i < walls.length ; i++) {
            walls[i] = new Wall(); //
            walls[i].setHeight( (int)(Math.random()*3)+1);
            System.out.println("Стена "+i+" имеет высоту "+walls[i].getHeight());
        }

        for (int i = 0; i < runLines.length ; i++) {
            runLines[i] = new RunLine();
            runLines[i].setDist( ((int)(Math.random()*10)+1)*10);
            System.out.println("Дорожка "+i+" имеет длину "+runLines[i].getDist());
        }

        // бегут роботы
        boolean result=true; // предполагаем, что робот пройдёт всё
        for (Robot robot : robots) {
            System.out.println("На дистанцию выходит "+robot.getName());
            for (int i = 0; i < (walls.length + runLines.length); i++) {
                // чётная i = прыгаем через стену, нечётная = бежим дорожку

                if ((i % 2) == 0) {
                    result=robot.jump(walls[i/2].getHeight());

                } else {
                    result=robot.run(runLines[i/2].getDist());

                    }

                if (result==false) {
                    System.out.println(robot.getName() + " сходит с полосы препятствий!");
                    break;
                }
            }
            if (result==true) {
                System.out.println(robot.getName()+" прошёл ВСЮ полосу препятствий!!");
            }
            System.out.println("***************************");
            result=true; // предполагаем, что робот пройдёт всё
        }

        // бегут коты
        result=true; // предполагаем, что кот пройдёт всё
        for (Cat cat : cats) {
            System.out.println("На дистанцию выходит " + cat.getName());
            for (int i = 0; i < (walls.length + runLines.length); i++) {
                // чётная i = прыгаем через стену, нечётная = бежим дорожку

                if ((i % 2) == 0) {
                    result = cat.jump(walls[i / 2].getHeight());
                } else {
                    result = cat.run(runLines[i / 2].getDist());
                }

            if (result == false) {
                System.out.println(cat.getName() + " сходит с полосы препятствий!");
                break;

            }
        }
            if (result==true) {
                System.out.println(cat.getName()+" прошёл ВСЮ полосу препятствий!!");
            }
            System.out.println("***************************");
            result=true; // предполагаем, что кот пройдёт всё
        }

        // бегут люди
        result=true; // предполагаем, что человек пройдёт всё
        for (Human human : humans) {
            System.out.println("На дистанцию выходит " + human.getName());
            for (int i = 0; i < (walls.length + runLines.length); i++) {
                // чётная i = прыгаем через стену, нечётная = бежим дорожку

                if ((i % 2) == 0) {
                    result = human.jump(walls[i / 2].getHeight());
                } else {
                    result = human.run(runLines[i / 2].getDist());
                }

            if (result == false) {
                System.out.println(human.getName() + " сходит с полосы препятствий!");
                break;

            }
        }
            if (result==true) {
                System.out.println(human.getName()+" прошёл ВСЮ полосу препятствий!!");
            }
            System.out.println("***************************");
            result=true; // предполагаем, что человек пройдёт всё
        }

    }
}
