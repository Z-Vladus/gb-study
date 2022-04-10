package ru.geekbrains.lesson6;

public class Example {
    int a,b;
    int total;

    public int getA (int a) {
        return a;
    }

    public int getB (int b) {
        return b;
    }

    public void setA (int a)   {
        this.a=a;
        this.total=this.a+this.b;
    }

    public void setB (int b)   {
        this.b=b;
        this.total=this.a+this.b;
    }

    public int getTotal () {
        return total;
    }

    public Example(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void info() {

    }

}
