// Написать метод, который меняет два элемента массива местами (массив может быть любого
// ссылочного типа)
public class Task1Objects<T extends Object> {

    private T[] objectsArray;

    public Task1Objects(T[] objectsArray) {
        this.objectsArray = objectsArray;
    }

    public void swapObjects (int index1, int index2) {
        System.out.println("size of objectsArray="+objectsArray.length);
        System.out.println("objectsArray=");
        for (T obj : objectsArray) {
            System.out.println(obj.toString());
        }

        if ((index1>objectsArray.length-1) || (index2>objectsArray.length-1)) {
            System.out.println("swapObjects: index out of bounds!");
        } else {
            T buf;
            buf=objectsArray[index1];
            objectsArray[index1]=objectsArray[index2];
            objectsArray[index2]=buf;
            System.out.println("swapObjects: "+index1+","+index2+" elements are swapped");
        }
    }

    public void printObjectsArray () {
        System.out.println("Printing objects array:");
        for (int i = 0; i < objectsArray.length; i++) {
            //todo хм, вот так не работает. Как же проверить, что элементы местами поменяны?
            System.out.println("index="+i+" element="+this.objectsArray.toString());
        }
    }

}
