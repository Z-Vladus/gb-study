package ru.GB.LVL3.Lesson1;

public class Compare {
    public static void main(String[] args) {
        Integer a= 1 , b=2;
        // ну норм
        if (a>b) {
            System.out.println("a>b");
        }
        String x="abc" , y="xyz";
        //так нельзя.
        //if (x>y) {
        //    System.out.println("x>y");
        //}
        // а как?
        System.out.println(x.compareTo(y));
        if (x.compareTo(y)>0) {
            // <0    =0   >0
            // x<y  x=y   x>y

            System.out.println("x>y");
        }




    }
}
