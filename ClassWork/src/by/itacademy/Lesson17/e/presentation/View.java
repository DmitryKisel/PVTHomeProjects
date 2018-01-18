package by.itacademy.Lesson17.e.presentation;

public class View {
    public static void main(String[] args) {
        View view = new View();
        view.startUI();
    }

    private Controller controller;
    public View(){
        controller = new Controller(this);
    }

    private void startUI(){
        System.out.println("What do you need?");
        controller.getMoney();
    }

    public void showGetMoneyResult(boolean ok){
        if (ok){
            System.out.println("Деньги сняты");
        }
        else {
            System.out.println("ошибка снятия денег");
        }
    }

    public void showMessage(String message){
        System.out.println("Error: " + message);
    }
}
