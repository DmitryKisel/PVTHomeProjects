package by.itacademy.lesson18;

public class MyCollection<T extends Number, R extends String > {
private T valueT;
private R valueR;

    public T getValueT() {
        return valueT;
    }

    public void setValueT(T valueT) {
        this.valueT = valueT;
    }

    public R getValueR() {
        return valueR;
    }

    public void setValueR(R valueR) {
        this.valueR = valueR;
    }
}

