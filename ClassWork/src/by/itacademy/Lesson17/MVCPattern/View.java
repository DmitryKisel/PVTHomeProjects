package by.itacademy.Lesson17.MVCPattern;

public class View {
    public static void main(String[] args) {
        View view = new View();
        view.startUI();
    }

    private  Controller controller;
    public View(){
        controller = new Controller(this);
    }

    private void startUI(){
        System.out.println("What do you need?");
        System.out.println(controller.getHello());
    }

    public void showMessage(String message){
        System.out.println("Error: " + message);
    }
}
