package ru.GB.LVL3.Lesson1;

public class Compare {
    public static void main(String[] args) {
        Integer a= 1 , b=2;
        // �� ����
        if (a>b) {
            System.out.println("a>b");
        }
        String x="abc" , y="xyz";
        //��� ������.
        //if (x>y) {
        //    System.out.println("x>y");
        //}
        // � ���?
        System.out.println(x.compareTo(y));
        if (x.compareTo(y)>0) {
            // <0    =0   >0
            // x<y  x=y   x>y

            System.out.println("x>y");
        }




    }
}
