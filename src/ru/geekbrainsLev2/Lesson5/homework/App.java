package ru.geekbrainsLev2.Lesson5.homework;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SimpleCalc();
        threadedCalc();

    }

    public static void SimpleCalc() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        System.out.print("Processing...[");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            if ((i % (arr.length / 10)) == 0) {
                System.out.print("*");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println("SimpleCalc method work time: " + (System.currentTimeMillis() -
                startTime) + " ms.");

    }

    public static void threadedCalc() throws InterruptedException {
        int size = 100_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        // Создаем два массива для левой и правой части исходного
        float[] arrLeft = new float[size / 2];
        float[] arrRight = new float[size / 2];
        // Копируем в них значения из большого массива
        System.arraycopy(arr, 0, arrLeft, 0, size / 2);
        System.arraycopy(arr, size / 2 - 1, arrRight, 0, size / 2);
        // Запускает два потока и параллельно просчитываем каждый малый массив
        Thread calcLeftThread = new Thread(() -> {
            int j = 0;
            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                if ((i % (arrLeft.length / 10)) == 0) {
                    System.out.println("calcLeftThread is done by " + (++j) * 10 + "%");
                }

            }
        });

        Thread calcRightThread = new Thread(() -> {
            int j = 0;
            for (int i = 0; i < arrRight.length; i++) {
                arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                if ((i % (arrRight.length / 10)) == 0) {
                    System.out.println("calcRightThread is done by " + (++j) * 10 + "%");
                }
            }

        });

        calcLeftThread.start();
        calcRightThread.start();
        calcLeftThread.join();
        calcRightThread.join();


        // Склеиваем малые массивы обратно в один большой
        float[] arrResult = new float[size];
        System.arraycopy(arrLeft, 0, arrResult, 0, size / 2);
        System.arraycopy(arrRight, 0, arrResult, size / 2, size / 2);
        System.out.println("threadedCalc work time: " + (System.currentTimeMillis() -
                startTime) + " ms.");


    }
}

