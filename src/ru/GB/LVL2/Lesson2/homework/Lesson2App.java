package ru.GB.LVL2.Lesson2.homework;

public class Lesson2App {

/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
при условии что подали на вход корректный массив).
Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);
Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано), то
будет сгенерировано исключение NumberFormatException.

public static void main(String args[]) {
try {
createReport();
} catch (IOException e) {
e.printStackTrace();
}
}
public static void createReport() throws IOException {
PrintWriter pw = new PrintWriter("report.txt");
p

*/
    public static void arrayTest(String[][] arr) throws MyArraySizeException {

    }

    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        try {
            arrayTest(arr);
        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
