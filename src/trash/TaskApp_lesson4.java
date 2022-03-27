package trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskApp_lesson4 {
    public static void main(String[] args) {
        //task Codewars
        // Given: int array.
        // remove all not-unique elements except last one.
        // {3,4,5,3,5,6} -> {4,3,5,6}
        // {3,4,5,3,5,3} -> {4,5,3}

        //System.out.println(Arrays.toString(getNewArray2(new int[] {3,4,5,3,5,3})));

    }

    public static int[] getNewArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = array.length; i>=0; i--) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        //return list.toArray(array[]);
        return array; //
    }
/*
    public static Integer[] getNewArray2(int[] array) {
        int[] result=new int[0];
        for (int i = array.length; i>=0; i--) {
            result=addValue(result, array[i]);
        }

    }

    public static int[] addValue(int[] array , int value) {
        if (arrayContainsValue(array,value)) {
            return array;
        }
        int[] result = new int[array.length+1];
        result[0]=value;
        for (int i = 0; i < array.length; i++) {
            result[i+1]=array[i];
        }
    }
*/
    public static boolean arrayContainsValue(int[] array , int value) {
        for (int arr: array) {
            if (arr == value) {
                return true;
            }

        }
        return false;
    }


}
