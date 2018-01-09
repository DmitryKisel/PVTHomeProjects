package by.itacademy.Lesson15.Singlton;

public class Manager {
    private String a;

    private Manager() {
    }
    private static Manager instance = new Manager();

    public synchronized static Manager getInstance(){

        return instance;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
}
