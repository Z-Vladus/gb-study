package ru.geekbrains.lesson7.homework7;

public class Bowl {
    int amount;
    int vol;
    // у тарелки есть объём
    public Bowl(int vol) {
        this.vol = vol;
    }

    // сколько сейчас в тарелке?

    public int getAmount() {
        return amount;
    }

    public void getGrAmount() {

        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            double k;
            k= ( (double) this.amount/this.vol)*10;
            if ( ((int)(k))>i ) {
                System.out.print("*");

            } else {
                System.out.print(" ");
            }

        }
        System.out.print("]");
    };

    //просто кладём корм до определённого уровня
    public void setAmount(int amount) {
        if ( amount>vol) {
            System.out.println("нельзя положить "+amount+" единиц корма. полный объём чаши="+vol+" корма в ней "+this.amount);
        } else {
            System.out.println("полный объём чаши="+vol+", корма в ней было "+this.amount+" стало "+amount);
            this.amount=amount;
        }
    }

    public void setVol(int vol) {
        this.vol = vol;
    }
}
