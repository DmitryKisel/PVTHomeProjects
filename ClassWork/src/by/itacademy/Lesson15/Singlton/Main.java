package by.itacademy.Lesson15.Singlton;

public class Main {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        manager.setA("jsdj");
        Manager manager2 = Manager.getInstance();

        System.out.println(manager2.getA());
    }


}
